package com.helger.jdmc.core.codegen;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.collection.multimap.IMultiMapSetBased;
import com.helger.collection.multimap.MultiHashMapLinkedHashSetBased;
import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsOrderedSet;

@NotThreadSafe
final class SPIImplMap
{
  private final IMultiMapSetBased <String, String, ICommonsOrderedSet <String>> m_aMML = new MultiHashMapLinkedHashSetBased <> ();

  public SPIImplMap ()
  {}

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
