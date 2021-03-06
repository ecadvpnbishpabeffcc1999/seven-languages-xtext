/*
 * generated by Xtext
 */
package org.xtext.scripting.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.xtext.scripting.ui.internal.ScriptingActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ScriptingExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(ScriptingActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		ScriptingActivator activator = ScriptingActivator.getInstance();
		return activator != null ? activator.getInjector(ScriptingActivator.ORG_XTEXT_SCRIPTING_SCRIPTING) : null;
	}

}
