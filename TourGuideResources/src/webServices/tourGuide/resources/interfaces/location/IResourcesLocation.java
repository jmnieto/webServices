/**
 * @author Walter Gugenberger
 * @date 30.05.2013 17:04:50
 * @version
 * @name UsersGestion.users.resourcesLayer.IResourcesLocation.java
 * @description IResourcesLocation
 */
package webServices.tourGuide.resources.interfaces.location;

import java.util.List;

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
    public Location addLocation(Location loc, String userId);

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
	    String link, String description, String userId);

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

    /**
     * Get Locations from a user id.
     * 
     * @param id
     *            User id
     * @return locations
     */
    public List<Location> getLocations(String id);

    /**
     * Get Locations around initial Location
     * 
     * @param myLocalization
     *            The initial location from geolocalization
     * @return locations
     */
    public List<Location> getLocations(Location myLocalization);

    /**
     * Delete from user id a place visited.
     * 
     * @param idUser
     *            User id
     * @param idLocation
     *            Location id
     * @return true if the deleteLocation was successful or false in the other
     *         case
     */
    public void deleteLocationByUserId(String idUser, List<Location> loc);

}
