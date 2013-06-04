package webServices.tourGuide.presentation.dataTransferObjects;

import java.io.Serializable;

/**
 * Esto representa a una respuesta del servicio de logado al cliente, donde se informa si el 
 * login fue exitoso y en caso de no ser asi el mensaje del motivo.
 * @author juanmanuel
 *
 */
public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = -2604057792153746293L;
	
	private boolean successful;
	private String	message;
	
	public ResponseDTO(){}
	
	public ResponseDTO(boolean successful, String message) {
		this.successful = successful;
		this.message 		 = message;
	}
	
	public ResponseDTO(boolean successful) {
		this.successful = successful;
		this.message 		 = "";
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
}
