/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version
 * @name guide.org.wuidl.noip.tourguide.database.UserAdministration.java
 * @description UserAdministration
 */
package webServices.tourGuide.resources.implementations.user;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.resources.interfaces.user.IResourcesUsers;


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
    @Override
    public User addUser(String name, String pass)
	    throws ExistingUserException {
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
    @Override
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
    @Override
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
    @Override
    public void synchronizeUser(User user) {
	UserAccessor ua = UserAccessor.getUserAccessor();
	ua.updateUser(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see users.resourcesLayer.IResourcesUsers#getUser(java.lang.String)
     */
    @Override
    public List<User> getUser(String nameUser) {
	UserAccessor ua = UserAccessor.getUserAccessor();
	return ua.retrieveUser(nameUser);
    }

    /*
     * (non-Javadoc)
     * 
     * @see users.resourcesLayer.IResourcesUsers#getUsers()
     */
    @Override
    public List<User> getUsers() {
	UserAccessor ua = UserAccessor.getUserAccessor();
	return ua.retrieveUsers();
    }

    /*
     * (non-Javadoc)
     * 
     * @see users.resourcesLayer.IResourcesUsers#existUser(java.lang.String)
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
    public void setName(User user, String newName) {
	user.setUsername(newName);
	UserAccessor ua = UserAccessor.getUserAccessor();
	ua.updateUser(user);
    }

}
