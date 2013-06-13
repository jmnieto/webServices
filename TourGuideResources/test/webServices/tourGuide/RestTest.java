package webServices.tourGuide;

import webServices.tourGuide.domainLogic.model.location.Location;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.rest.client.Rest;

public class RestTest {

    /**
     * @param args
     * @throws ExistingUserException
     */
    public static void main(String[] args) throws ExistingUserException {
	Rest r = new Rest();
	User u = new User();
	u.setId("0");
	u.setUsername("walter");
	u.setPass("123456");
	// System.out.println(u.toString());
	// u = r.addUser(u);
	// System.out.println(u.getId());
	Location l = new Location();
	l.setName("Innsbruck");
	l.setLat("");
	l.setLng("");
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
	Location loc = r.addLocation("New York", "40.67", "-73.94",
		"http://www.nyc.com", "New York City", "1");
	r.addLocation(l, "2");
	System.out.println(r.getUsers().toString());
	System.out.println(r.getUser("walter"));
	System.out.println(loc.toString());

    }
}
