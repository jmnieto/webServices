/**
 * @author Juan Manuel Nieto-Moreno
 */
package webServices.tourGuide.domainLogic.model.user;

public enum RoleUser {
	
	/**
	 * An user as administrator will have a complete control over the application.
	 */
	Administrator,
	
	/**
	 * An user as Collaborator will have a wide control over the application, but it
	 * will not able to use the user management.
	 */
	Collaborator,
	
	/**
	 * A Consumer will just be able to have a look of the application.
	 */
	Consumer
}