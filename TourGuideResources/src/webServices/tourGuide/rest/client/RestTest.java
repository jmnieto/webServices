package webServices.tourGuide.rest.client;

import webServices.tourGuide.domainLogic.model.location.Location;
import webServices.tourGuide.domainLogic.model.user.RoleUser;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;

public class RestTest {

    /**
     * @param args
     * @throws ExistingUserException
     */
    public static void main(String[] args) throws ExistingUserException {
	Rest r = new Rest();
	User u = new User();
	u.setConnect(false);
	u.setRole(RoleUser.Consumer);
	u.setId("0");
	u.setUsername("walter");
	u.setPass("123456");
	// System.out.println(u.toString());
	u = r.addUser(u);
	// System.out.println(u.toString());
	Location l = new Location();
	l.setName("Innsbruck");
	l.setLink("http://www.innsbruck.gv.at");
	l.setDescription("Innsbruck is a town in Tyrol, Austria.");
	System.out.println(r.existUser("walter"));
	// List<User> wuidl = r.getUser("walter");
	// List<Location> s = r.addLocation(l, "1");
	// if (wuidl == null) {
	// System.out.println("null");
	// } else {
	// System.out.println(wuidl.toString());
	// }
	// System.out.println(s.toString());
	Location loc = r.addLocation("Nola", "43.12312312", "123.343242",
		"http://www.nola.com", "New Orleans Lousiana", "1");
	System.out.println(loc.toString());

    }
}
