/**
 * Copyright (C) 2018-2021 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.jdmc.core.codegen;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.state.EChange;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO.InitSettings;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JCodeModelException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JReturn;
import com.helger.jcodemodel.JTryBlock;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMGenClass;
import com.helger.jdmc.core.datamodel.JDMGenField;
import com.helger.photon.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.audit.AuditHelper;
import com.helger.photon.security.object.BusinessObjectHelper;

@Immutable
final class JDMCodeGenManager
{
  private JDMCodeGenManager ()
  {}

  public static void createMainManagerClass (@Nonnull final JDMCodeModel cm,
                                             @Nonnull final JDMGenClass aClass,
                                             @Nonnull final JDefinedClass jInterface,
                                             @Nonnull final JDefinedClass jDomainClass) throws JCodeModelException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQManagerClassName (), EClassType.CLASS);
    jClass._extends (cm.ref (AbstractPhotonMapBasedWALDAO.class).narrow (jInterface, jDomainClass));
    jClass.javadoc ().add ("<p>Default Manager implementation of for class {@link " + aClass.getFQClassName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);
    jClass.annotate (ThreadSafe.class);

    // Constructor 1
    {
      final JMethod jCtor = jClass.constructor (JMod.PUBLIC);
      final JVar jParam = jCtor.param (JMod.FINAL, cm.ref (String.class), "sFilename");
      jParam.annotate (Nullable.class);
      jCtor._throws (DAOException.class);
      jCtor.body ().add (JInvocation._super ().arg (jDomainClass.dotclass ()).arg (jParam));
    }

    // Constructor 2
    {
      final JMethod jCtor = jClass.constructor (JMod.PUBLIC);
      final JVar jParam1 = jCtor.param (JMod.FINAL, cm.ref (String.class), "sFilename");
      jParam1.annotate (Nullable.class);
      final JVar jParam2 = jCtor.param (JMod.FINAL, cm.ref (InitSettings.class).narrow (jDomainClass), "aInitSettings");
      jParam2.annotate (Nonnull.class);
      jCtor._throws (DAOException.class);
      jCtor.body ().add (JInvocation._super ().arg (jDomainClass.dotclass ()).arg (jParam1).arg (jParam2));
    }

    // create method
    {
      final JMethod jCreate = jClass.method (JMod.PUBLIC | JMod.FINAL, jInterface, "create" + jDomainClass.name ());
      jCreate.annotate (Nonnull.class);
      jCreate.javadoc ().add ("Create a new object and add it to the internal map.");
      jCreate.javadoc ().addReturn ().add ("The created object and never <code>null</code>.");

      final JInvocation jInit = jDomainClass._new ();
      for (final JDMGenField aField : aClass.fields ())
      {
        final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
        final boolean bIsEffectivePrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);

        // List or field?
        AbstractJType jFieldType = cm.ref (aField.getType (), eMultiplicity);
        if (eMultiplicity.isOpenEnded ())
          jFieldType = cm.ref (ICommonsList.class).narrow (jFieldType);

        // method param
        final JVar jParam = jCreate.param (JMod.FINAL, jFieldType, aField.getJavaVarName (eMultiplicity));
        if (!bIsEffectivePrimitive)
        {
          if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
            jParam.annotate (Nullable.class);
          else
            jParam.annotate (Nonnull.class);
          if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
            jParam.annotate (Nonempty.class);
        }

        // JavaDoc
        jCreate.javadoc ().addParam (jParam).add (aField.getParamJavaDoc ());

        // Pass to ctor
        jInit.arg (jParam);
      }

      jCreate.body ().addSingleLineComment ("Create new object");
      final JVar jRet = jCreate.body ().decl (JMod.FINAL, jDomainClass, "a" + jDomainClass.name (), jInit);

      // internal create
      jCreate.body ().addSingleLineComment ("Save internally");
      jCreate.body ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("lock"));
      final JTryBlock jTry = jCreate.body ()._try ();
      jTry.body ().add (JExpr.invoke ("internalCreateItem").arg (jRet));
      jTry._finally ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("unlock"));

      // Audit
      jCreate.body ().addSingleLineComment ("Success audit");
      final JInvocation jAudit = cm.ref (AuditHelper.class)
                                   .staticInvoke ("onAuditCreateSuccess")
                                   .arg (jDomainClass.staticRef ("OT"))
                                   .arg (jRet.invoke ("getID"));
      for (final JDMGenField aField : aClass.fields ())
      {
        final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();

        // List or field?
        final AbstractJType jFieldType = cm.ref (aField.getType (), eMultiplicity);
        if (jFieldType.isPrimitive ())
          jAudit.arg (jFieldType.boxify ().staticInvoke ("valueOf").arg (JExpr.ref (aField.getJavaVarName (eMultiplicity))));
        else
          jAudit.arg (JExpr.ref (aField.getJavaVarName (eMultiplicity)));
      }
      jCreate.body ().add (jAudit);

      // Done
      jCreate.body ()._return (jRet);
    }

    // update method
    {
      final JMethod jUpdate = jClass.method (JMod.PUBLIC | JMod.FINAL, cm.ref (EChange.class), "update" + jDomainClass.name ());
      jUpdate.annotate (Nonnull.class);
      jUpdate.javadoc ().add ("Update an existing object with new values.");
      jUpdate.javadoc ()
             .addReturn ()
             .add ("{@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.");

      final JVar jParamID = jUpdate.param (JMod.FINAL, cm.ref (String.class), "s" + jDomainClass.name () + "ID");
      jParamID.annotate (Nullable.class);
      jUpdate.javadoc ().addParam (jParamID).add ("ID of the object to be updated. May be <code>null</code>.");

      // Start resolving object
      final JVar jImpl = jUpdate.body ()
                                .decl (JMod.FINAL, jDomainClass, "a" + jDomainClass.name (), JExpr.invoke ("getOfID").arg (jParamID));

      // Check preconditions
      jUpdate.body ().addSingleLineComment ("Check preconditions");
      final JBlock jIfNull = jUpdate.body ()._if (jImpl.eqNull ())._then ();
      jIfNull.add (cm.ref (AuditHelper.class)
                     .staticInvoke ("onAuditModifyFailure")
                     .arg (jDomainClass.staticRef ("OT"))
                     .arg ("all")
                     .arg (jParamID)
                     .arg ("no-such-id"));
      jIfNull._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      final JBlock jIfDeleted = jUpdate.body ()._if (jImpl.invoke ("isDeleted"))._then ();
      jIfDeleted.add (cm.ref (AuditHelper.class)
                        .staticInvoke ("onAuditModifyFailure")
                        .arg (jDomainClass.staticRef ("OT"))
                        .arg ("all")
                        .arg (jParamID)
                        .arg ("already-deleted"));
      jIfDeleted._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      // internal update
      jUpdate.body ().addSingleLineComment ("Update internally");
      jUpdate.body ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("lock"));
      final JTryBlock jTry = jUpdate.body ()._try ();
      final JVar jChange = jTry.body ().decl (cm.ref (EChange.class), "eChange", cm.ref (EChange.class).staticRef ("UNCHANGED"));

      for (final JDMGenField aField : aClass.fields ())
      {
        final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
        final boolean bIsEffectivePrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);

        // List or field?
        AbstractJType jFieldType = cm.ref (aField.getType (), eMultiplicity);
        if (eMultiplicity.isOpenEnded ())
          jFieldType = cm.ref (ICommonsList.class).narrow (jFieldType);

        // method param
        final JVar jParam = jUpdate.param (JMod.FINAL, jFieldType, aField.getJavaVarName (eMultiplicity));
        if (!bIsEffectivePrimitive)
        {
          if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
            jParam.annotate (Nullable.class);
          else
            jParam.annotate (Nonnull.class);
          if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
            jParam.annotate (Nonempty.class);
        }

        // JavaDoc
        jUpdate.javadoc ().addParam (jParam).add (aField.getParamJavaDoc ());

        jTry.body ().assign (jChange, jChange.invoke ("or").arg (jImpl.invoke (aField.getMethodSetterName ()).arg (jParam)));
      }

      jTry.body ()._if (jChange.invoke ("isUnchanged"), new JReturn (cm.ref (EChange.class).staticRef ("UNCHANGED")));
      jTry.body ().add (cm.ref (BusinessObjectHelper.class).staticInvoke ("setLastModificationNow").arg (jImpl));
      jTry.body ().add (JExpr.invoke ("internalUpdateItem").arg (jImpl));
      jTry._finally ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("unlock"));

      // Audit
      jUpdate.body ().addSingleLineComment ("Success audit");
      final JInvocation jAudit = cm.ref (AuditHelper.class)
                                   .staticInvoke ("onAuditModifySuccess")
                                   .arg (jDomainClass.staticRef ("OT"))
                                   .arg ("all")
                                   .arg (jImpl.invoke ("getID"));
      for (final JDMGenField aField : aClass.fields ())
      {
        final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();

        // List or field?
        final AbstractJType jFieldType = cm.ref (aField.getType (), eMultiplicity);
        if (jFieldType.isPrimitive ())
          jAudit.arg (jFieldType.boxify ().staticInvoke ("valueOf").arg (JExpr.ref (aField.getJavaVarName (eMultiplicity))));
        else
          jAudit.arg (JExpr.ref (aField.getJavaVarName (eMultiplicity)));
      }
      jUpdate.body ().add (jAudit);

      jUpdate.body ()._return (cm.ref (EChange.class).staticRef ("CHANGED"));
    }

    // mark deleted method
    {
      final JMethod jMarkDel = jClass.method (JMod.PUBLIC | JMod.FINAL, cm.ref (EChange.class), "mark" + jDomainClass.name () + "Deleted");
      jMarkDel.annotate (Nonnull.class);
      jMarkDel.javadoc ()
              .add ("Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #mark" +
                    jDomainClass.name () +
                    "Undeleted(String)} method.");
      jMarkDel.javadoc ()
              .addReturn ()
              .add ("{@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.");

      final JVar jParamID = jMarkDel.param (JMod.FINAL, cm.ref (String.class), "s" + jDomainClass.name () + "ID");
      jParamID.annotate (Nullable.class);
      jMarkDel.javadoc ().addParam (jParamID).add ("ID of the object to be marked as deleted. May be <code>null</code>.");

      // Start resolving object
      jMarkDel.body ().addSingleLineComment ("Check preconditions");
      final JVar jImpl = jMarkDel.body ()
                                 .decl (JMod.FINAL, jDomainClass, "a" + jDomainClass.name (), JExpr.invoke ("getOfID").arg (jParamID));

      // Check preconditions
      final JBlock jIfNull = jMarkDel.body ()._if (jImpl.eqNull ())._then ();
      jIfNull.add (cm.ref (AuditHelper.class)
                     .staticInvoke ("onAuditDeleteFailure")
                     .arg (jDomainClass.staticRef ("OT"))
                     .arg (jParamID)
                     .arg ("no-such-id"));
      jIfNull._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      // Check before write lock
      final JBlock jIfDeleted = jMarkDel.body ()._if (jImpl.invoke ("isDeleted"))._then ();
      jIfDeleted.add (cm.ref (AuditHelper.class)
                        .staticInvoke ("onAuditDeleteFailure")
                        .arg (jDomainClass.staticRef ("OT"))
                        .arg (jParamID)
                        .arg ("already-deleted"));
      jIfDeleted._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      // internal update
      jMarkDel.body ().addSingleLineComment ("Mark internally as deleted");
      jMarkDel.body ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("lock"));
      final JTryBlock jTry = jMarkDel.body ()._try ();
      final JBlock jIfNotDel = jTry.body ()
                                   ._if (cm.ref (BusinessObjectHelper.class)
                                           .staticInvoke ("setDeletionNow")
                                           .arg (jImpl)
                                           .invoke ("isUnchanged"))
                                   ._then ();
      jIfNotDel.add (cm.ref (AuditHelper.class)
                       .staticInvoke ("onAuditDeleteFailure")
                       .arg (jDomainClass.staticRef ("OT"))
                       .arg (jParamID)
                       .arg ("already-deleted"));
      jIfNotDel._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      jTry.body ().add (JExpr.invoke ("internalMarkItemDeleted").arg (jImpl));
      jTry._finally ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("unlock"));

      // Audit
      jMarkDel.body ().addSingleLineComment ("Success audit");
      jMarkDel.body ()
              .add (cm.ref (AuditHelper.class)
                      .staticInvoke ("onAuditDeleteSuccess")
                      .arg (jDomainClass.staticRef ("OT"))
                      .arg (jParamID)
                      .arg ("mark-deleted"));

      jMarkDel.body ()._return (cm.ref (EChange.class).staticRef ("CHANGED"));
    }

    // mark undeleted method
    {
      final JMethod jMarkUndel = jClass.method (JMod.PUBLIC | JMod.FINAL,
                                                cm.ref (EChange.class),
                                                "mark" + jDomainClass.name () + "Undeleted");
      jMarkUndel.annotate (Nonnull.class);
      jMarkUndel.javadoc ()
                .add ("Restore an existing object that was marked deleted using the {@link #mark" +
                      jDomainClass.name () +
                      "Deleted(String)} method.");
      jMarkUndel.javadoc ()
                .addReturn ()
                .add ("{@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.");

      final JVar jParamID = jMarkUndel.param (JMod.FINAL, cm.ref (String.class), "s" + jDomainClass.name () + "ID");
      jParamID.annotate (Nullable.class);
      jMarkUndel.javadoc ().addParam (jParamID).add ("ID of the object to be marked as undeleted. May be <code>null</code>.");

      // Start resolving object
      jMarkUndel.body ().addSingleLineComment ("Check preconditions");
      final JVar jImpl = jMarkUndel.body ()
                                   .decl (JMod.FINAL, jDomainClass, "a" + jDomainClass.name (), JExpr.invoke ("getOfID").arg (jParamID));

      // Check preconditions
      final JBlock jIfNull = jMarkUndel.body ()._if (jImpl.eqNull ())._then ();
      jIfNull.add (cm.ref (AuditHelper.class)
                     .staticInvoke ("onAuditUndeleteFailure")
                     .arg (jDomainClass.staticRef ("OT"))
                     .arg (jParamID)
                     .arg ("no-such-id"));
      jIfNull._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      // Check before write lock
      final JBlock jIfDeleted = jMarkUndel.body ()._if (jImpl.invoke ("isDeleted").not ())._then ();
      jIfDeleted.add (cm.ref (AuditHelper.class)
                        .staticInvoke ("onAuditUndeleteFailure")
                        .arg (jDomainClass.staticRef ("OT"))
                        .arg (jParamID)
                        .arg ("not-deleted"));
      jIfDeleted._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      // internal update
      jMarkUndel.body ().addSingleLineComment ("Mark internally as undeleted");
      jMarkUndel.body ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("lock"));
      final JTryBlock jTry = jMarkUndel.body ()._try ();
      final JBlock jIfNotDel = jTry.body ()
                                   ._if (cm.ref (BusinessObjectHelper.class)
                                           .staticInvoke ("setUndeletionNow")
                                           .arg (jImpl)
                                           .invoke ("isUnchanged"))
                                   ._then ();
      jIfNotDel.add (cm.ref (AuditHelper.class)
                       .staticInvoke ("onAuditUndeleteFailure")
                       .arg (jDomainClass.staticRef ("OT"))
                       .arg (jParamID)
                       .arg ("not-deleted"));
      jIfNotDel._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      jTry.body ().add (JExpr.invoke ("internalMarkItemUndeleted").arg (jImpl));
      jTry._finally ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("unlock"));

      // Audit
      jMarkUndel.body ().addSingleLineComment ("Success audit");
      jMarkUndel.body ()
                .add (cm.ref (AuditHelper.class)
                        .staticInvoke ("onAuditUndeleteSuccess")
                        .arg (jDomainClass.staticRef ("OT"))
                        .arg (jParamID));

      jMarkUndel.body ()._return (cm.ref (EChange.class).staticRef ("CHANGED"));
    }

    // delete method
    {
      final JMethod jDelete = jClass.method (JMod.PUBLIC | JMod.FINAL, cm.ref (EChange.class), "delete" + jDomainClass.name ());
      jDelete.annotate (Nonnull.class);
      jDelete.javadoc ().add ("Delete an existing object so that it can <b>NOT</b> be restored afterwards.");
      jDelete.javadoc ().add ("\nNote: if an object was previously marked as deleted it can finally be deleted with this method.");
      jDelete.javadoc ()
             .addReturn ()
             .add ("{@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.");

      final JVar jParamID = jDelete.param (JMod.FINAL, cm.ref (String.class), "s" + jDomainClass.name () + "ID");
      jParamID.annotate (Nullable.class);
      jDelete.javadoc ().addParam (jParamID).add ("ID of the object to be deleted. May be <code>null</code>.");

      // Start resolving object
      final JVar jImpl = jDelete.body ().decl (JMod.FINAL, jDomainClass, "aDeleted" + jDomainClass.name ());

      // internal update
      jDelete.body ().addSingleLineComment ("Delete internally");
      jDelete.body ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("lock"));
      final JTryBlock jTry = jDelete.body ()._try ();
      jTry.body ().assign (jImpl, JExpr.invoke ("internalDeleteItem").arg (jParamID));
      final JBlock jIfNotDel = jTry.body ()._if (jImpl.eqNull ())._then ();
      jIfNotDel.add (cm.ref (AuditHelper.class)
                       .staticInvoke ("onAuditDeleteFailure")
                       .arg (jDomainClass.staticRef ("OT"))
                       .arg (jParamID)
                       .arg ("no-such-id"));
      jIfNotDel._return (cm.ref (EChange.class).staticRef ("UNCHANGED"));

      jTry.body ().add (cm.ref (BusinessObjectHelper.class).staticInvoke ("setDeletionNow").arg (jImpl));
      jTry._finally ().add (JExpr.ref ("m_aRWLock").invoke ("writeLock").invoke ("unlock"));

      // Audit
      jDelete.body ().addSingleLineComment ("Success audit");
      jDelete.body ()
             .add (cm.ref (AuditHelper.class)
                     .staticInvoke ("onAuditDeleteSuccess")
                     .arg (jDomainClass.staticRef ("OT"))
                     .arg (jParamID)
                     .arg ("removed"));

      jDelete.body ()._return (cm.ref (EChange.class).staticRef ("CHANGED"));
    }

    // get Of ID
    {
      final JMethod jGet = jClass.method (JMod.PUBLIC | JMod.FINAL, jInterface, "get" + jDomainClass.name () + "OfID");
      jGet.annotate (Nullable.class);
      jGet.javadoc ().add ("Get the object with the provided ID.");
      jGet.javadoc ().addReturn ().add ("The object with the ID or <code>null</code> if no such object is present.");

      final JVar jParamID = jGet.param (JMod.FINAL, cm.ref (String.class), "s" + jDomainClass.name () + "ID");
      jParamID.annotate (Nullable.class);
      jGet.javadoc ().addParam (jParamID).add ("ID of the object to be retrieved. May be <code>null</code>.");

      jGet.body ()._return (JExpr.invoke ("getOfID").arg (jParamID));
    }
  }
}
