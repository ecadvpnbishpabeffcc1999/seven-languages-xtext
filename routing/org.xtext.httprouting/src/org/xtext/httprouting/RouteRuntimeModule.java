/*
 * generated by Xtext
 */
package org.xtext.httprouting;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.xtext.httprouting.scoping.RouteImportedNamespaceScopeProvider;
import org.xtext.httprouting.scoping.RouteScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class RouteRuntimeModule extends
		org.xtext.httprouting.AbstractRouteRuntimeModule {
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return RouteScopeProvider.class;
	}
	
	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
		.to(RouteImportedNamespaceScopeProvider.class);
	}
}