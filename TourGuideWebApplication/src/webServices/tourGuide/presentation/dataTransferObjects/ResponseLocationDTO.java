package webServices.tourGuide.presentation.dataTransferObjects;

import java.io.Serializable;

/**
 * Esto representa a una respuesta del servicio de logado al cliente, donde se informa si el 
 * login fue exitoso y en caso de no ser asi el mensaje del motivo.
 * @author juanmanuel
 *
 */
public class ResponseLocationDTO implements Serializable{

	
	private static final long serialVersionUID = 5853969174560812227L;
	
	
	private boolean loginSuccessful;
	private String	message;
	
	public ResponseLocationDTO(){}
	
	public ResponseLocationDTO(boolean loginSuccessful, String message) {
		this.loginSuccessful = loginSuccessful;
		this.message 		 = message;
	}
	
	public ResponseLocationDTO(boolean loginSuccessful) {
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
