/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version 1.0
 * @name guide.org.wuidl.noip.tourguide.database.LocationAdministrator.java
 * @description LocationAdministrator
 */
package org.noip.wuidl.tourguide.database;

import org.noip.wuidl.tourguide.databeans.Location;

/**
 * The Class LocationAdministrator.
 */
public class LocationAdministration {

	/** The instance. */
	private static LocationAdministration instance;

	/**
	 * Instantiates a new location administration.
	 */
	private LocationAdministration() {
	}

	/**
	 * Gets the single instance of LocationAdministration.
	 * 
	 * @return single instance of LocationAdministration
	 */
	public static LocationAdministration getInstance() {
		if (instance == null) {
			instance = new LocationAdministration();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesLocation#addLocation(users.domainLogic
	 * .business.Location)
	 */
	/**
	 * Adds the location.
	 * 
	 * @param loc
	 *            the loc
	 * @return the location
	 */
	public Location addLocation(Location loc) {
		LocationAccessor la = LocationAccessor.getLocationAccessor();
		la.saveLocation(loc);
		return loc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesLocation#addLocation(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
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
			String link, String description) {
		Location loc = new Location();
		loc.setName(name);
		loc.setLat(lat);
		loc.setLng(lng);
		loc.setLink(link);
		loc.setDescription(description);
		LocationAccessor la = LocationAccessor.getLocationAccessor();
		la.saveLocation(loc);
		return loc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesLocation#deleteLocation(users.domainLogic
	 * .business.Location)
	 */
	/**
	 * Delete location.
	 * 
	 * @param loc
	 *            the loc
	 */
	public void deleteLocation(Location loc) {
		LocationAccessor la = LocationAccessor.getLocationAccessor();
		la.deleteLocation(loc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesLocation#deleteLocation(java.lang.String)
	 */
	/**
	 * Delete location.
	 * 
	 * @param name
	 *            the name
	 */
	public void deleteLocation(String name) {
		LocationAccessor la = LocationAccessor.getLocationAccessor();
		la.deleteLocation(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesLocation#updateLocation(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	/**
	 * Update location.
	 * 
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param link
	 *            the link
	 */
	public void updateLocation(String name, String description, String link) {
		LocationAccessor la = LocationAccessor.getLocationAccessor();
		la.updateLocation(name, description, link);
	}

}
