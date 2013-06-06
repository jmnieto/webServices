/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:49
 * @version
 * @name guide.org.noip.wuidl.tourguide.test.TestDatabase.java
 * @description TestDatabase
 */
package org.noip.wuidl.tourguide.test;

import org.noip.wuidl.tourguide.database.LocationAdministration;
import org.noip.wuidl.tourguide.database.UserAdministration;
import org.noip.wuidl.tourguide.databeans.Location;
import org.noip.wuidl.tourguide.databeans.User;

/**
 * The Class TestDatabase.
 */
public class TestDatabase {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		User u = new User();
		Location l = new Location();
		u.setUsername("Hugo");
		u.setPass("password");
		l.setName("Innsbruck");
		l.setLink("http://www.innsbruck.gv.at");
		l.setDescription("Innsbruck is a town in Tyrol, Austria.");

		UserAdministration ua = UserAdministration.getInstance();
		ua.addUser(u);
		LocationAdministration la = LocationAdministration.getInstance();
		la.addLocation(l);
	}

}
