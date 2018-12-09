package com.helger.jdmc.core.datamodel;

import java.io.Serializable;

import javax.annotation.Nonnull;

/**
 * Per-classType configuration. E.g. read from the <code>$config</code> key in a
 * JDM file.
 *
 * @author Philip Helger
 */
public class JDMClassTypeConfiguration implements Serializable
{
  public static final boolean DEFAULT_CREATE_MANAGER = false;

  private boolean m_bCreateManager = DEFAULT_CREATE_MANAGER;

  public JDMClassTypeConfiguration ()
  {}

  public boolean isCreateManager ()
  {
    return m_bCreateManager;
  }

  @Nonnull
  public JDMClassTypeConfiguration setCreateManager (final boolean b)
  {
    m_bCreateManager = b;
    return this;
  }
}
