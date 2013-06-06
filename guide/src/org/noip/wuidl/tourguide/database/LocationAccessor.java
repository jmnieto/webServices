/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version
 * @name guide.org.wuidl.noip.tourguide.database.LocationAccessor.java
 * @description LocationAccessor
 */
package org.noip.wuidl.tourguide.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.noip.wuidl.tourguide.constants.ServiceConstants;
import org.noip.wuidl.tourguide.databeans.Location;

/**
 * The Class LocationAccessor.
 */
public class LocationAccessor {

	/** The db. */
	private DatabaseConnection db;

	/** The instance. */
	private static LocationAccessor instance = null;

	/**
	 * Instantiates a new location accessor.
	 */
	private LocationAccessor() {
		this.db = DatabaseConnection.getConnection(ServiceConstants.DB_PATH);
	}

	/**
	 * Gets the location accessor. SINGLETON
	 * 
	 * @return the location accessor
	 */
	public static LocationAccessor getLocationAccessor() {
		if (instance == null) {
			instance = new LocationAccessor();
		}
		return instance;
	}

	/**
	 * Checks if a location is contained in the DB.
	 * 
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	public boolean contains(String name) {
		String query = "SELECT * FROM places WHERE name= ?";
		ResultSet result = null;
		PreparedStatement containsStatement = this.db.preparedStatement(query);
		try {
			containsStatement.setString(1, name);
			result = containsStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (result == null) {
				return false;
			}
			if (result.next() != true) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * DB contains an id.
	 * 
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	@SuppressWarnings("unused")
	private boolean containsId(String id) {
		String query = "SELECT * FROM places WHERE id= ?";
		PreparedStatement containsStatement = this.db.preparedStatement(query);
		ResultSet result = null;
		try {
			containsStatement.setString(1, id);
			result = containsStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (result.next() != true) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Gets the id of an entry.
	 * 
	 * @param loc
	 *            the loc
	 * @return the id
	 */
	private String getId(Location loc) {
		String id = "-1";
		if (contains(loc.getName())) {
			String query = "SELECT * FROM places WHERE name= ?";
			ResultSet result = null;
			PreparedStatement idStatement = this.db.preparedStatement(query);
			try {
				idStatement.setString(1, loc.getName());
				result = idStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (result == null) {
					return null;
				}
				id = result.getString("id");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			loc.setId(id);
		}
		return id;
	}

	/**
	 * Save location to the DB.
	 * 
	 * @param loc
	 *            the loc
	 */
	public void saveLocation(Location loc) {
		try {
			if (!contains(loc.getName())) {
				String query = "INSERT INTO places (name, coordinates link,description) VALUES (?,?,?,?,?)";
				PreparedStatement saveUser = this.db.preparedStatement(query);
				saveUser.setString(1, loc.getName());
				saveUser.setString(2, loc.getLat() + ":" + loc.getLng());
				saveUser.setString(3, loc.getLink());
				saveUser.setString(4, loc.getDescription());
				saveUser.executeUpdate();
				String id = getId(loc);
				loc.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve location.
	 * 
	 * @param name
	 *            the name
	 * @return the location
	 */
	public Location retrieveLocation(String name) {
		List<Location> tmp = retrieveLocations();
		for (Location l : tmp) {
			if (l.getName().equals(name)) {
				return l;
			}
		}
		return null;
	}

	/**
	 * Retrieves all locations.
	 * 
	 * @return the list
	 */
	public List<Location> retrieveLocations() {
		ResultSet result = null;
		String query = "SELECT * FROM places";
		PreparedStatement idStatement = this.db.preparedStatement(query);
		try {
			result = idStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toLocationList(result);
	}

	/**
	 * Parses the Result of a DB query and returns it as a List.
	 * 
	 * @param result
	 *            the result
	 * @return the list
	 */
	private List<Location> toLocationList(ResultSet result) {
		if (result == null) {
			return null;
		}
		List<Location> loc = new ArrayList<Location>();
		try {
			while (result.next()) {
				Location u = new Location();
				u.setId(result.getString("id"));
				u.setName(result.getString("name"));
				u.setLat(parseCoordinates(result.getString("coordinates"))[0]);
				u.setLng(parseCoordinates(result.getString("coordinates"))[1]);
				u.setLink(result.getString("link"));
				u.setDescription(result.getString("description"));
				u.setTimestamp(result.getString("time"));
				loc.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loc;
	}

	/**
	 * Parses the coordinates. Coordinates are stored in one field in the DB.
	 * Latitude:Longitude e.g. 100.0000:123.123
	 * 
	 * @param coordinates
	 *            the coordinates
	 * @return the string[]
	 */
	private String[] parseCoordinates(String coordinates) {
		// lat:lng
		return coordinates.split(":");
	}

	/**
	 * Update a location.
	 * 
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param link
	 *            the link
	 */
	public void updateLocation(String name, String description, String link) {
		if (contains(name)) {
			String query = "UPDATE places SET description=?, link=? WHERE name=?";
			PreparedStatement updateUser = this.db.preparedStatement(query);
			try {
				updateUser.setString(1, description);
				updateUser.setString(2, link);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Delete a location using its name to indetify it in the DB. A Location is
	 * unique by its name.
	 * 
	 * @param name
	 *            the name
	 */
	public void deleteLocation(String name) {
		if (contains(name)) {
			String query = "DELETE FROM places WHERE name=?";
			PreparedStatement deleteUser = this.db.preparedStatement(query);
			try {
				deleteUser.setString(1, name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Delete location. Uses the deleteLocation(String name) method to delete a
	 * Location.
	 * 
	 * @param loc
	 *            the loc
	 */
	public void deleteLocation(Location loc) {
		deleteLocation(loc.getName());
	}

}
