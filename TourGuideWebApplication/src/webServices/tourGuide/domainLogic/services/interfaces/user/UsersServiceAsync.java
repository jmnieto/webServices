package webServices.tourGuide.domainLogic.services.interfaces.user;



import java.util.List;

import webServices.tourGuide.presentation.dataTransferObjects.ResponseDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLoginDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsersServiceAsync {

	void logoutUser(AsyncCallback<Void> callback);
	
	void addUser(String name, String pass, String passConfir, String role,
			AsyncCallback<ResponseDTO> callback);
	
	void setNameUser(String newName, AsyncCallback<Void> callback);

	void setOpinionViewUser(boolean allOpinions, AsyncCallback<Void> callback);

	void setPassUser(String newPass, String oldPass,
			AsyncCallback<Void> callback);

	void deleteUser(String name, AsyncCallback<Void> callback);

	void existUser(String name, AsyncCallback<Boolean> callback);

	void loginUser(String name, String pass,
			AsyncCallback<ResponseLoginDTO> callback);

	void getUserConnected(AsyncCallback<UserDTO> callback);

	void connectUser(AsyncCallback<Boolean> callback);

	void disconnect(AsyncCallback<Void> callback);

	void getUsers(AsyncCallback<List<UserDTO>> callback);
}
