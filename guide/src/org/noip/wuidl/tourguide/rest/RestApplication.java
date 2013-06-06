/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:50
 * @version
 * @name guide.org.noip.wuidl.tourguide.rest.RestApplication.java
 * @description RestApplication
 */
package org.noip.wuidl.tourguide.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * The Class RestApplication.
 */
public class RestApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(UserRestService.class);
		classes.add(LocationRestService.class);
		return classes;
	}
}
