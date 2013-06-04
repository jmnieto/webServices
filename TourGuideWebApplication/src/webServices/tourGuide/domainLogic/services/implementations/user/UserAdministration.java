package webServices.tourGuide.domainLogic.services.implementations.user;

import java.util.List;

import webServices.tourGuide.domainLogic.model.user.RoleUser;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.resources.interfaces.user.IResourcesUsers;

public class UserAdministration implements IResourcesUsers {

	@Override
	public User addUser(User arg0) throws ExistingUserException {
		// TODO ELIMINAR ESTA CLASE
		return null;
	}

	@Override
	public User addUser(String arg0, String arg1, RoleUser arg2)
			throws ExistingUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkPassword(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delUser(User arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existUser(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(User arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPassword(User arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void synchronizeUser(User arg0) {
		// TODO Auto-generated method stub

	}

}
