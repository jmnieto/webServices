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

import users.domainLogic.business.RoleUser;
import users.domainLogic.business.User;
import users.excepctions.ExistingUserException;
import users.resourcesLayer.IResourcesUsers;

/**
 * The Class UserAdministration.
 */
public class UserAdministration implements IResourcesUsers {

	private static UserAdministration instance;

	private UserAdministration() {
	}

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
	public User addUser(String name, String pass, RoleUser role)
			throws ExistingUserException {
		UserAccessor ua = UserAccessor.getUserAccessor();
		User u = new User(name, pass, role);
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
	public User addUser(User user) throws ExistingUserException {
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
	public void synchronizeUser(User user) {
		UserAccessor ua = UserAccessor.getUserAccessor();
		ua.updateUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#getUser(java.lang.String)
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
	public List<User> getUsers() {
		UserAccessor ua = UserAccessor.getUserAccessor();
		return ua.retrieveUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see users.resourcesLayer.IResourcesUsers#existUser(java.lang.String)
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
	public void setName(User user, String newName) {
		user.setUsername(newName);
		UserAccessor ua = UserAccessor.getUserAccessor();
		ua.updateUser(user);
	}

}
