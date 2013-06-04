/**
 * @author Walter Gugenberger
 * @date 30.05.2013 17:04:50
 * @version
 * @name UsersGestion.users.resourcesLayer.IResourcesLocation.java
 * @description IResourcesLocation
 */
package webServices.tourGuide.resources.interfaces.location;

import webServices.tourGuide.domainLogic.model.location.Location;


/**
 * The Interface IResourcesLocation.
 */
public interface IResourcesLocation {

	/**
	 * Adds the location.
	 * 
	 * @param loc
	 *            the loc
	 * @return the location
	 */
	public Location addLocation(Location loc);

	/**
	 * Adds the location.
	 * 
	 * @param name
	 *            the name
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param link
	 *            the link
	 * @param description
	 *            the description
	 * @return the location
	 */
	public Location addLocation(String name, String lat, String lng,
			String link, String description);

	/**
	 * Delete location.
	 * 
	 * @param loc
	 *            the loc
	 */
	public void deleteLocation(Location loc);

	/**
	 * Delete location.
	 * 
	 * @param name
	 *            the name of the location
	 */
	public void deleteLocation(String name);

	/**
	 * Update location. If a location is updated only its description and link
	 * are updated. Not its coordinates or name.
	 * 
	 * @param description
	 *            the description
	 * @param link
	 *            the link
	 */
	public void updateLocation(String name, String description, String link);

}