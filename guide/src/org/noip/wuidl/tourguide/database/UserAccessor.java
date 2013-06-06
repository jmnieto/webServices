/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version
 * @name guide.org.wuidl.noip.tourguide.database.UserAccessor.java
 * @description UserAccessor
 */
package org.noip.wuidl.tourguide.database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.noip.wuidl.tourguide.constants.ServiceConstants;
import org.noip.wuidl.tourguide.databeans.User;

/**
 * The Class UserAccessor.
 */
public class UserAccessor {

	/** The db. */
	private DatabaseConnection db;

	/** The instance. */
	private static UserAccessor instance = null;

	/**
	 * Instantiates a new user accessor.
	 */
	private UserAccessor() {
		this.db = DatabaseConnection.getConnection(ServiceConstants.DB_PATH);
	}

	/**
	 * Gets the user accessor.
	 * 
	 * @return the user accessor
	 */
	public static UserAccessor getUserAccessor() {
		if (instance == null) {
			instance = new UserAccessor();
		}
		return instance;
	}

	/**
	 * Hash a password using SHA1.
	 * 
	 * @param name
	 *            the name
	 * @param pwd
	 *            the pwd
	 * @return the string
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */
	private String hashPassword(String name, String pwd)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		byte[] tmp = md.digest((name + pwd).getBytes());
		return bytesToHex(tmp);
	}

	/**
	 * Bytes to hex.
	 * 
	 * @param bytes
	 *            the bytes
	 * @return the string
	 */
	private String bytesToHex(byte[] bytes) {
		final char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[(j * 2) + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	/**
	 * Checks if a User is contained in the DB. The query returns a list of
	 * users that could match the requested user. if the name and the hashedPwd
	 * are identically true is returned. In general using the Method that gets a
	 * user by id is encouraged.
	 * 
	 * @param u
	 *            the u
	 * @return true, if successful
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */
	public boolean containsUser(User u) throws NoSuchAlgorithmException {
		String query = "SELECT * FROM users WHERE name= ? AND hashedPwd = ?";
		ResultSet result = null;
		PreparedStatement containsStatement = this.db.preparedStatement(query);
		try {
			containsStatement.setString(1, u.getUsername());
			containsStatement.setString(2,
					hashPassword(u.getUsername(), u.getPass()));
			result = containsStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Contains id.
	 * 
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	private boolean containsId(String id) {
		String query = "SELECT * FROM users WHERE id= ?";
		PreparedStatement containsStatement = this.db.preparedStatement(query);
		ResultSet result = null;
		try {
			containsStatement.setString(1, id);
			result = containsStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Contains name.
	 * 
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	public boolean containsName(String name) {
		String query = "SELECT * FROM users WHERE name= ?";
		PreparedStatement containsStatement = this.db.preparedStatement(query);
		ResultSet result = null;
		try {
			containsStatement.setString(1, name);
			result = containsStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Gets the id.
	 * 
	 * @param u
	 *            the u
	 * @return the id
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */
	private String getId(User u) throws NoSuchAlgorithmException {
		String id = "-1";
		if (containsUser(u)) {
			String query = "SELECT * FROM users WHERE name= ? AND hashedPwd = ?";
			ResultSet result = null;
			PreparedStatement idStatement = this.db.preparedStatement(query);
			try {
				idStatement.setString(1, u.getUsername());
				idStatement.setString(2,
						hashPassword(u.getUsername(), u.getPass()));
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
			u.setId(id);
		}
		return id;
	}

	/**
	 * Save user.
	 * 
	 * @param u
	 *            the u
	 */
	public void saveUser(User u) {
		try {
			if (!containsUser(u)) {
				String query = "INSERT INTO users (name, hashedpwd) VALUES (?,?)";
				PreparedStatement saveUser = this.db.preparedStatement(query);
				saveUser.setString(1, u.getUsername());
				saveUser.setString(2,
						hashPassword(u.getUsername(), u.getPass()));
				saveUser.executeUpdate();
				String id = getId(u);
				u.setId(id);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve user.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<User> retrieveUser(String name) {
		List<User> tmp = retrieveUsers();
		List<User> users = new ArrayList<User>();
		for (User u : tmp) {
			if (u.getUsername().equals(name)) {
				users.add(u);
			}
		}
		return users;
	}

	/**
	 * Retrieve users.
	 * 
	 * @return the list
	 */
	public List<User> retrieveUsers() {
		ResultSet result = null;
		String query = "SELECT * FROM users";
		PreparedStatement idStatement = this.db.preparedStatement(query);
		try {
			result = idStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toUserList(result);
	}

	/**
	 * To user list.
	 * 
	 * @param result
	 *            the result
	 * @return the list
	 */
	private List<User> toUserList(ResultSet result) {
		if (result == null) {
			return null;
		}
		List<User> users = new ArrayList<User>();
		try {
			while (result.next()) {
				User u = new User();
				u.setId(result.getString("id"));
				u.setUsername(result.getString("name"));
				u.setPass(result.getString("hashedpwd"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Update user.
	 * 
	 * @param u
	 *            the u
	 */
	public void updateUser(User u) {
		if (containsId(u.getId())) {
			String query = "UPDATE users SET name= ?, hashedpwd=? WHERE id=?";
			PreparedStatement updateUser = this.db.preparedStatement(query);
			try {
				updateUser.setString(1, u.getUsername());
				updateUser.setString(2,
						hashPassword(u.getUsername(), u.getPass()));
				updateUser.setString(3, u.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Delete user from DB.
	 * 
	 * @param u
	 *            the u
	 */
	public void deleteUser(User u) {
		if (containsId(u.getId())) {
			String query = "DELETE FROM users WHERE id=?";
			PreparedStatement deleteUser = this.db.preparedStatement(query);
			try {
				deleteUser.setString(1, u.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
