package org.xtext.cradle.lib;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xtext.cradle.lib.impl.RunUtil;

@SuppressWarnings("all")
public class ClassExtensions {
  public static void runMain(final Class<? extends Object> clazz) {
    try {
      List<String> _emptyList = CollectionLiterals.<String>emptyList();
      RunUtil.runMain(clazz, ((String[])Conversions.unwrapArray(_emptyList, String.class)));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
