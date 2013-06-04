package webServices.tourGuide.presentation.dataTransferObjects;

import java.io.Serializable;

/**
 * Esto representa a una respuesta del servicio de logado al cliente, donde se informa si el 
 * login fue exitoso y en caso de no ser asi el mensaje del motivo.
 * @author juanmanuel
 *
 */
public class ResponseLoginDTO implements Serializable{

	private static final long serialVersionUID = -2604057792153746293L;
	
	private boolean loginSuccessful;
	private String	message;
	
	public ResponseLoginDTO(){}
	
	public ResponseLoginDTO(boolean loginSuccessful, String message) {
		this.loginSuccessful = loginSuccessful;
		this.message 		 = message;
	}
	
	public ResponseLoginDTO(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
		this.message 		 = "";
	}

	public boolean isLoginSuccessful() {
		return loginSuccessful;
	}

	public void setLoginSuccessful(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
}
