package org.noip.wuidl.tourguide.test;

import org.noip.wuidl.tourguide.database.LocationAdministration;
import org.noip.wuidl.tourguide.database.UserAdministration;

import users.domainLogic.business.Location;
import users.domainLogic.business.RoleUser;
import users.domainLogic.business.User;
import users.excepctions.ExistingUserException;

public class TestDatabase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User u = new User();
		Location l = new Location();
		u.setUsername("Hugo");
		u.setPass("password");
		u.setRole(RoleUser.Consumer);
		l.setName("Innsbruck");
		l.setLink("http://www.innsbruck.gv.at");
		l.setDescription("Innsbruck is a town in Tyrol, Austria.");

		UserAdministration ua = UserAdministration.getInstance();
		try {
			ua.addUser(u);
		} catch (ExistingUserException e) {
			e.printStackTrace();
		}
		LocationAdministration la = LocationAdministration.getInstance();
		la.addLocation(l);

	}

}
