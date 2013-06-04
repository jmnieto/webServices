package webServices.tourGuide.domainLogic.services.interfaces.user;

import java.util.List;

import webServices.tourGuide.presentation.dataTransferObjects.ResponseDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLoginDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * Servicio relacionado con la gestion de usuarios.
 * Futuros usuarios administradores.
 * @author bogulin
 *
 */
@RemoteServiceRelativePath("users")
public interface UsersService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static UsersServiceAsync instance;
		public static UsersServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(UsersService.class);
			}
			return instance;
		}
	}
	
	
	public ResponseLoginDTO loginUser(String name, String pass);
	public void    logoutUser();
	
	//usado para conectar un usuario que persiste en Session.
	public boolean connectUser();
	public void	   disconnect();
	
	public UserDTO getUserConnected();
	public List<UserDTO> getUsers();
	
	public boolean existUser(String name);
	
	public ResponseDTO    addUser(String name, String pass, String passConfir, String role);
	public void    setNameUser(String newName);
	public void    setPassUser(String newPass, String oldPass);
	public void    setOpinionViewUser(boolean allOpinions);
	
	public void    deleteUser(String name);
}
