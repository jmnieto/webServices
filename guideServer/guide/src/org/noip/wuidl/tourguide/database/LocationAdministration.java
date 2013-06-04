/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version 1.0
 * @name guide.org.wuidl.noip.tourguide.database.LocationAdministrator.java
 * @description LocationAdministrator
 */
package org.noip.wuidl.tourguide.database;

import users.domainLogic.business.Location;
import users.resourcesLayer.IResourcesLocation;

/**
 * The Class LocationAdministrator.
 */
public class LocationAdministration implements IResourcesLocation {

	private static LocationAdministration instance;

	private LocationAdministration() {
	}

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
	public void updateLocation(String name, String description, String link) {
		LocationAccessor la = LocationAccessor.getLocationAccessor();
		la.updateLocation(name, description, link);
	}

}
