/**
 * @author Juan Manuel Nieto-Moreno
 */
package webServices.tourGuide.resources.interfaces.user;

import java.util.List;

import webServices.tourGuide.domainLogic.model.user.RoleUser;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;


public interface IResourcesUsers {

    /**
     * A simple user will be saved without any information parameters.
     * @param name Name of the user
     * @param pass Password of the user
     * @param role Role of the user on the application. The use of the administration functions will depend on the user role.
     * @return An user with a set id will be returned
     */
    public User addUser(String name, String pass, RoleUser role) throws ExistingUserException;

    /**
     * It will saved an user which it has already been created.
     * @param user User that it is wanted to save.
     * @return The same user will be returned but it will contain a new id.
     */
    public User 	addUser(User user) throws ExistingUserException;


    /**
     * The user introduced by parameter will be deleted from the system.
     * @param user User that it is desired to delete.
     */
    public void 	delUser(User user);

    /**
     * The user introduced by parameter will be synchronize in the system.
     * @param user
     */
    public void		synchronizeUser(User user);


    /**
     * An user which has a username equal to the parameter nameUser will be returned.
     * @param nameUser Name of the user that it is wanted to look for.
     * @return It will be returned either a instance of the user which has an username equal to the parameter nameUser or NULL if there is any user with nameUser as its username.
     */
    public List<User>     getUser(String nameUser);

    /**
     * It gives as result every users that there is in the system.
     * @return A list with every users.
     */
    public List<User> getUsers();


    /**
     * Given an username, it is checked out if there is some user with this username.
     * @param nameUser Username to check out.
     * @return Either True if there is an user with this username or False if not
     */
    public boolean  existUser(String nameUser);

    /**
     * It will check out if the given password is valid.
     * @param nameUser Username of the user to check.
     * @param password Password to check out.
     * @return Either True if the password is valid or False if not
     */
    public boolean  checkPassword(String nameUser, String password);

    public void setPassword(User user, String newPassword);
    public void setName(User user, String newName);
}
