package webServices.tourGuide;

import webServices.tourGuide.domainLogic.model.location.Location;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.resources.implementations.location.LocationAdministration;
import webServices.tourGuide.resources.implementations.user.UserAdministration;

public class TestDatabase {

    /**
     * @param args
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
	try {
	    ua.addUser(u);
	} catch (ExistingUserException e) {
	    e.printStackTrace();
	}
	LocationAdministration la = LocationAdministration.getInstance();
	la.addLocation(l, "hah");

    }

}
