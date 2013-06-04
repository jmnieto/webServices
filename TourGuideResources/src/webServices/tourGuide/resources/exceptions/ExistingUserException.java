package webServices.tourGuide.resources.exceptions;

public class ExistingUserException extends Exception {

	private static final long serialVersionUID = 1468703152488500261L;
	
	public ExistingUserException() {
		super();
	}

	public ExistingUserException(String msg) {
		super(msg);
	}

	public ExistingUserException(AssertionError error) {
		super(error);
	}
}
