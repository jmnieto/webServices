/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version
 * @name guide.org.wuidl.noip.tourguide.database.UserAdministration.java
 * @description UserAdministration
 */
package org.noip.wuidl.tourguide.database;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.noip.wuidl.tourguide.databeans.User;

/**
 * The Class UserAdministration.
 */
public class UserAdministration {

	/** The instance. */
	private static UserAdministration instance;

	/**
	 * Instantiates a new user administration.
	 */
	private UserAdministration() {
	}

	/**
	 * Gets the single instance of UserAdministration.
	 * 
	 * @return single instance of UserAdministration
	 */
	public static UserAdministration getInstance() {
		if (instance == null) {
			instance = new UserAdministration();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#addUser(java.lang.String,
	 * java.lang.String, users.domainLogic.business.RoleUser)
	 */
	/**
	 * Adds the user.
	 * 
	 * @param name
	 *            the name
	 * @param pass
	 *            the pass
	 * @return the user
	 */
	public User addUser(String name, String pass) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		User u = new User(name, pass);
		ua.saveUser(u);
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesUsers#addUser(users.domainLogic.business
	 * .User)
	 */
	/**
	 * Adds the user.
	 * 
	 * @param user
	 *            the user
	 * @return the user
	 */
	public User addUser(User user) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		ua.saveUser(user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesUsers#delUser(users.domainLogic.business
	 * .User)
	 */
	/**
	 * Del user.
	 * 
	 * @param user
	 *            the user
	 */
	public void delUser(User user) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		ua.deleteUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesUsers#synchronizeUser(users.domainLogic
	 * .business.User)
	 */
	/**
	 * Synchronize user.
	 * 
	 * @param user
	 *            the user
	 */
	public void synchronizeUser(User user) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		ua.updateUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#getUser(java.lang.String)
	 */
	/**
	 * Gets the user.
	 * 
	 * @param nameUser
	 *            the name user
	 * @return the user
	 */
	public User getUser(String nameUser) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		return ua.retrieveUser(nameUser).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#getUsers()
	 */
	/**
	 * Gets the users.
	 * 
	 * @return the users
	 */
	public List<User> getUsers() {
		UserAccessor ua = UserAccessor.getUserAccessor();
		return ua.retrieveUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#existUser(java.lang.String)
	 */
	/**
	 * Exist user.
	 * 
	 * @param nameUser
	 *            the name user
	 * @return true, if successful
	 */
	public boolean existUser(String nameUser) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		return ua.containsName(nameUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#checkPassword(java.lang.String,
	 * java.lang.String)
	 */
	/**
	 * Check password.
	 * 
	 * @param nameUser
	 *            the name user
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	public boolean checkPassword(String nameUser, String password) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		User u = new User();
		u.setUsername(nameUser);
		u.setPass(password);
		try {
			return ua.containsUser(u);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesUsers#setPassword(users.domainLogic.business
	 * .User, java.lang.String)
	 */
	/**
	 * Sets the password.
	 * 
	 * @param user
	 *            the user
	 * @param newPassword
	 *            the new password
	 */
	public void setPassword(User user, String newPassword) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		user.setPass(newPassword);
		ua.updateUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * users.resourcesLayer.IResourcesUsers#setName(users.domainLogic.business
	 * .User, java.lang.String)
	 */
	/**
	 * Sets the name.
	 * 
	 * @param user
	 *            the user
	 * @param newName
	 *            the new name
	 */
	public void setName(User user, String newName) {
		user.setUsername(newName);
		UserAccessor ua = UserAccessor.getUserAccessor();
		ua.updateUser(user);
	}

}
