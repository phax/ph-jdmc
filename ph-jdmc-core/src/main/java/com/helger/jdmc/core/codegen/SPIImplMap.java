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

@NotThreadSafe
final class SPIImplMap
{
  private final IMultiMapSetBased <String, String, ICommonsOrderedSet <String>> m_aMML = new MultiHashMapLinkedHashSetBased <> ();

  public SPIImplMap ()
  {}

  public void readInitial (@Nonnull final File aSrcResources)
  {
    for (final File aFile : new FileSystemIterator (aSrcResources, "META-INF/services"))
      if (aFile.isFile ())
      {
        // Filename = interface FQCN
        final String sKey = aFile.getName ();
        final ICommonsOrderedSet <String> aSet = new CommonsLinkedHashSet <> ();
        SimpleFileIO.readFileLines (aFile, StandardCharsets.UTF_8, aSet::add);
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
