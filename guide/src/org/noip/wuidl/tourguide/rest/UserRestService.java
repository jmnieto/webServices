/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:52
 * @version
 * @name guide.org.noip.wuidl.tourguide.rest.UserRestService.java
 * @description UserRestService
 */
package org.noip.wuidl.tourguide.rest;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.noip.wuidl.tourguide.database.UserAccessor;
import org.noip.wuidl.tourguide.databeans.User;

/**
 * The Class UserRestService.
 */
@Path("user")
public class UserRestService {

	/**
	 * Fetch location.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	@GET
	@Path("get/{name}")
	@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> fetchLocation(@PathParam("name") String name) {
		UserAccessor lA = UserAccessor.getUserAccessor();
		return lA.retrieveUser(name);
	}

	/**
	 * Checks if is contained.
	 * 
	 * @param u
	 *            the u
	 * @return the boolean
	 */
	@POST
	@Path("indb")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean isContained(User u) {
		UserAccessor lA = UserAccessor.getUserAccessor();
		try {
			return lA.containsUser(u);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Adds the location.
	 * 
	 * @param l
	 *            the l
	 */
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addLocation(User l) {
		UserAccessor lA = UserAccessor.getUserAccessor();
		lA.saveUser(l);
	}

	/**
	 * Delete location.
	 * 
	 * @param l
	 *            the l
	 */
	@POST
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteLocation(User l) {
		UserAccessor lA = UserAccessor.getUserAccessor();
		lA.deleteUser(l);
	}
}
