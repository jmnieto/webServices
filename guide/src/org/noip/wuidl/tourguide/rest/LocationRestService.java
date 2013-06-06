/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.rest.LocationRestService.java
 * @description LocationRestService
 */
package org.noip.wuidl.tourguide.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.noip.wuidl.tourguide.database.LocationAccessor;
import org.noip.wuidl.tourguide.databeans.Location;

/**
 * The Class LocationRestService.
 */
@Path("location")
public class LocationRestService {

	/**
	 * Fetch location.
	 * 
	 * @param name
	 *            the name
	 * @return the location
	 */
	@GET
	@Path("getLocation/{name}")
	@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public Location fetchLocation(@PathParam("name") String name) {
		LocationAccessor lA = LocationAccessor.getLocationAccessor();
		return lA.retrieveLocation(name);
	}

	/**
	 * Adds the location.
	 * 
	 * @param l
	 *            the l
	 */
	@POST
	@Path("addToDb")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addLocation(Location l) {
		LocationAccessor lA = LocationAccessor.getLocationAccessor();
		lA.saveLocation(l);
	}

	/**
	 * Delete location.
	 * 
	 * @param l
	 *            the l
	 */
	@POST
	@Path("deleteFromDb")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteLocation(Location l) {
		LocationAccessor lA = LocationAccessor.getLocationAccessor();
		lA.deleteLocation(l);
	}

	/**
	 * Delete location.
	 * 
	 * @param l
	 *            the l
	 */
	@POST
	@Path("deleteByLocationByName")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteLocation(String l) {
		LocationAccessor lA = LocationAccessor.getLocationAccessor();
		lA.deleteLocation(l);
	}

}
