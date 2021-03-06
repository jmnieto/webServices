package webServices.tourGuide.domainLogic.services.implementations.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.domainLogic.services.interfaces.user.UsersService;
import webServices.tourGuide.domainLogic.services.rest.Rest;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLoginDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.resources.interfaces.user.IResourcesUsers;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UsersServiceImpl extends RemoteServiceServlet implements
UsersService {

    private static final long serialVersionUID = -1143464717952842548L;

    // logger
    // final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    private IResourcesUsers usersManager;

    @Override
    public void init() {
	// logger.info("Initialising the user management service...");

	// It has to be changed to a REST consumer
	this.usersManager = new Rest();// (IResourcesUsers) new
	// UserAdministration();

	// logger.info("The user management service was successfully initialised.");
    }

    @Override
    public ResponseLoginDTO loginUser(String name, String pass) {

	if ((name == null) || (pass == null)) {
	    throw new IllegalArgumentException("Parameters are null.");
	}

	ResponseLoginDTO result = new ResponseLoginDTO(true);

	User userList = null;
	User user = null;
	try {
	    if (this.usersManager.existUser(name)
		    && this.usersManager.checkPassword(name, pass)) {
		userList = this.usersManager.getUser(name);
		user = userList;

	    } else {
		result.setLoginSuccessful(false);
		result.setMessage("Username or Password incorrect.");
		return result;
	    }
	} catch (Exception e) {
	    // //logger.error("Error in login for user {} : {} ", new
	    // Object[]{name,e.getMessage()});
	    throw new IllegalStateException("Error in login.");
	}

	if (getUserConnected() != null) {
	    removeAttributeSession();
	}

	// User could be connected on other session.
	// if(user.isConnect()){
	// result.setLoginSuccessful(false);
	// result.setMessage("User " + name + "is already logged.");
	// return result;
	// }

	connectOrDisconnect(user, true);

	setAttributeSession(convertUserDTO(user));

	return result;
    }

    @Override
    public void logoutUser() {

	UserDTO userDTO = getUserConnected();

	if (userDTO == null) {
	    throw new IllegalStateException("User is not connected.");
	}

	User user = null;
	List<User> userList = null;

	try {
	    if (this.usersManager.existUser(userDTO.getName())) {
		userList = this.usersManager.getUser(userDTO.getName());
		user = userList.get(0);
	    } else {
		throw new IllegalArgumentException(
			"It was impossible to find the user.");
	    }
	} catch (Exception e) {
	    // logger.error("Error in logout: ", e);
	    throw new IllegalStateException("Error in logout.");
	}

	// if(!user.isConnect()){
	// throw new IllegalStateException("User " + user.getUsername() +
	// " not connected.");
	// }

	connectOrDisconnect(user, false);

	removeAttributeSession();
    }

    @Override
    public boolean connectUser() {
	boolean result;

	UserDTO userDTO = getUserConnected();
	if (userDTO == null) {
	    result = false;
	} else {
	    User user = null;
	    List<User> userList = null;
	    try {
		System.out.println(".........PREGUNTO SI EXISTE");
		if (this.usersManager.existUser(userDTO.getName())) {
		    System.out.println(".........PUES POYICA, SI EXISTE");
		    userList = this.usersManager.getUser(userDTO.getName());
		    user = userList.get(0);
		} else {
		    System.out.println(".........LA VIEN NO EXISTE EL USER");
		    result = false;
		    removeAttributeSession();
		}
	    } catch (Exception e) {
		// logger.error("Error in logout: " + e.getMessage());
		throw new IllegalStateException("Error in logout.");
	    }

	    // If the user is connected, we will interrupt the method...
	    // if(user.isConnect()){
	    // result = false;
	    // removeAttributeSession();
	    // }else{
	    // connectOrDisconnect(user, true);
	    // result = true;
	    // }
	}

	return result = true;
    }

    @Override
    public void disconnect() {

	UserDTO userDTO = getUserConnected();
	if (userDTO != null) {
	    List<User> userList = null;
	    User user = null;

	    try {
		if (this.usersManager.existUser(userDTO.getName())) {
		    userList = this.usersManager.getUser(userDTO.getName());
		} else {
		    removeAttributeSession();
		}
	    } catch (Exception e) {
		// logger.error("Error in logout: ", e);
		throw new IllegalStateException("Error in logout.");
	    }

	    connectOrDisconnect(user, false);
	}
    }

    private void connectOrDisconnect(User user, boolean connect) {
	// user.setConnect(connect);

	try {
	    this.usersManager.synchronizeUser(user);
	} catch (Exception e) {
	    // logger.error("Error change state :", e);
	    throw new IllegalStateException("Error in logout.");
	}
    }

    @Override
    public boolean existUser(String name) {

	if (name == null) {
	    throw new IllegalArgumentException("Name is null.");
	}

	boolean result = false;

	try {
	    result = this.usersManager.existUser(name);
	} catch (Exception e) {
	    // logger.error("Error checking for user :", e);
	    throw new IllegalStateException("Error existUser.");
	}

	return result;
    }

    // We should delete String role.
    @Override
    public ResponseDTO addUser(String name, String pass, String passConfir,
	    String role) {
	if ((name == null) || name.isEmpty() || (pass == null)
		|| pass.isEmpty() || (passConfir == null)
		|| passConfir.isEmpty() || (role == null) || role.isEmpty()) {
	    // logger.error("Se intento almacenar un usuario con los parametros erroneos.");
	    throw new IllegalArgumentException("Parametros nulos o vacios.");
	}

	if (pass != passConfir) {
	    // logger.error("Se intento insertar un usuario con el password y la confirmacion distintos.");
	    throw new IllegalArgumentException(
		    "El password y su confirmacion no coinciden.");
	}

	ResponseDTO response = new ResponseDTO(true);

	// logger.info("Anyadiendo un nuevo usuario con username:" + name);

	// logger.trace("Creando el atriburo especifico...");
	// Attribute atri = new Attribute("ShowAllOpinions", "true");

	// logger.trace("Creando usuario con atributo...");
	User user = new User(name, pass);
	// user.getAttibutes().add(atri);

	try {
	    this.usersManager.addUser(user);
	} catch (ExistingUserException e) {
	    response.setSuccessful(false);
	    response.setMessage("Invalid Username, already exists in the system.");
	} catch (Exception e) {
	    response.setSuccessful(false);
	    response.setMessage("Internal error adding the user.");
	}

	return response;
    }

    @Override
    public void setNameUser(String newName) {
	UserDTO userDTO = getUserConnected();

	if (userDTO == null) {
	    throw new IllegalArgumentException("User not connected.");
	}

	try {
	    List<User> userList = this.usersManager.getUser(userDTO.getName());
	    User user = userList.get(0);
	    this.usersManager.setName(user, newName);

	    userDTO.setName(newName);

	    setAttributeSession(userDTO);

	} catch (Exception e) {
	    // logger.error("Error change name user :", e);
	    throw new IllegalStateException("Error changing name.");
	}
    }

    @Override
    public void setPassUser(String newPass, String oldPass) {
	UserDTO userDTO = getUserConnected();

	if (userDTO == null) {
	    throw new IllegalArgumentException("User not connected.");
	}

	try {
	    if (!this.usersManager.checkPassword(userDTO.getName(), oldPass)) {
		throw new IllegalArgumentException("Password wrong.");
	    }

	    // User user = usersManager.getUser(userDTO.getName());
	    List<User> userList = this.usersManager.getUser(userDTO.getName());
	    User user = userList.get(0);
	    if (user == null) {
		throw new IllegalArgumentException("Usuario no encontrado.");
	    }

	    this.usersManager.setPassword(user, newPass);

	} catch (Exception e) {
	    // logger.error("Error change password user :" + e.getMessage());
	    throw new IllegalStateException("Error changing password.");
	}

    }

    @Override
    public void setOpinionViewUser(boolean allOpinions) {
	UserDTO userDto = getUserConnected();

	if (userDto == null) {
	    // logger.error("No se encontro nigun usuario en las Cookies.");
	    throw new IllegalArgumentException(
		    "No se encontro ningun usuario conectado.");
	}

	// logger.trace("Recuperando el usuario del sistema.");
	// User user = usersManager.getUser(userDto.getName());
	List<User> userList = this.usersManager.getUser(userDto.getName());
	User user = userList.get(0);
	if (user == null) {
	    // logger.error("No existe ningun usuario con el nombre: " +
	    // userDto.getName());
	    throw new IllegalArgumentException(
		    "No se encontro ningun usuario registrado en el sistema con el nombre:"
			    + userDto.getName());
	}

	// logger.trace("Estrableciendo atributo de showAllOpinions.");
	// for(Attribute attri : user.getAttibutes()){
	// if(attri.getName().equals("ShowAllOpinions")){
	// attri.setValue(Boolean.toString(allOpinions));
	// }
	// }

	// logger.trace("Sincronizando usuario.");
	this.usersManager.synchronizeUser(user);

	// logger.trace("Estableciendo nueva cookie.");
	userDto.setOpinionView(allOpinions);
	removeAttributeSession();
	setAttributeSession(userDto);
    }

    @Override
    public void deleteUser(String name) {
	if ((name == null) || name.isEmpty()) {
	    // logger.error("Se intento eliminar un nulo.");
	    throw new IllegalArgumentException("Parametros introducidos nulos.");
	}

	// User user = usersManager.getUser(name);
	List<User> userList = this.usersManager.getUser(name);
	User user = userList.get(0);

	if (user == null) {
	    // logger.error("Se intento borrar un usuario que no existe.");
	    throw new IllegalArgumentException(
		    "Nombre de usuario introducido invalido.");
	}

	this.usersManager.delUser(user);
    }

    @Override
    public UserDTO getUserConnected() {
	return getAttributeSession("session.user");
    }

    @Override
    public List<UserDTO> getUsers() {
	// logger.trace("Obteniendo los usuarios del sistema.");

	// UserDTO userResult = new UserDTO();
	List<UserDTO> result = new ArrayList<UserDTO>();

	// UserDTO userConected = getUserConnected();

	// if(userConected == null){
	// // //logger.trace("No se encontro la variable del usuario.");
	// throw new
	// IllegalStateException("No encontro ningun usuario conectado.");
	// }

	try {

	    // userResult = userManager.getUser();
	    List<User> user;
	    user = this.usersManager.getUsers();
	    for (int i = 0; i < user.size(); i++) {
		// if(user.getId().compareTo(userConected.getId()) != 0){
		result.add(convertUserDTO(user.get(i)));
	    }
	} catch (Exception exc) {
	    System.out.println(exc);
	}
	return result;
	// return userResult;
    }

    private UserDTO convertUserDTO(User user) {
	boolean showAllOpinios = false;

	// for(Attribute attri: user.getAttibutes()){
	// if(attri.getName().equals("ShowAllOpinions")){
	// showAllOpinios = Boolean.parseBoolean(attri.getValue());
	// break;
	// }
	// }
	return new UserDTO(user.getId(), user.getUsername(), showAllOpinios,
		showAllOpinios, showAllOpinios);
    }

    private UserDTO getAttributeSession(String name) {
	HttpServletRequest request = this.getThreadLocalRequest();
	return (UserDTO) request.getSession().getAttribute(name);
    }

    private void setAttributeSession(UserDTO user) {
	HttpServletRequest request = this.getThreadLocalRequest();
	request.getSession().setAttribute("session.user", user);
    }

    private void removeAttributeSession() {
	HttpServletRequest request = this.getThreadLocalRequest();
	request.getSession().removeAttribute("session.user");
    }

}
