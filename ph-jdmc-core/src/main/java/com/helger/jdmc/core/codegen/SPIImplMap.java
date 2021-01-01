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

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.collection.multimap.IMultiMapSetBased;
import com.helger.collection.multimap.MultiHashMapLinkedHashSetBased;
import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.CommonsLinkedHashSet;
import com.helger.commons.collection.impl.ICommonsOrderedSet;
import com.helger.commons.io.file.FileSystemIterator;
import com.helger.commons.io.file.SimpleFileIO;
import com.helger.commons.string.StringHelper;

@NotThreadSafe
final class SPIImplMap
{
  private final IMultiMapSetBased <String, String, ICommonsOrderedSet <String>> m_aMML = new MultiHashMapLinkedHashSetBased <> ();

  public SPIImplMap ()
  {}

  public void readInitial (@Nonnull final File aSrcResources)
  {
    final File aServicesDir = new File (aSrcResources, "META-INF/services");
    if (aServicesDir.isDirectory ())
      for (final File aFile : new FileSystemIterator (aServicesDir))
        if (aFile.isFile ())
        {
          // Filename = interface FQCN
          final String sKey = aFile.getName ();
          final ICommonsOrderedSet <String> aSet = new CommonsLinkedHashSet <> ();
          SimpleFileIO.readFileLines (aFile, StandardCharsets.UTF_8, sLine -> {
            final String sCleanLine = StringHelper.trim (sLine);
            if (StringHelper.hasText (sCleanLine) && !sCleanLine.startsWith ("#"))
              aSet.add (sCleanLine);
          });
          if (aSet.isNotEmpty ())
            m_aMML.put (sKey, aSet);
        }
  }

  public void register (@Nonnull final Class <?> aInterface, @Nonnull @Nonempty final String sImplClass)
  {
    ValueEnforcer.notNull (aInterface, "Interface");
    ValueEnforcer.notEmpty (sImplClass, "ImplClass");
    // Key must contain package name!
    m_aMML.putSingle (aInterface.getName (), sImplClass);
  }

  @Nonnull
  public Iterable <Map.Entry <String, ICommonsOrderedSet <String>>> getAll ()
  {
    return m_aMML.entrySet ();
  }
}
