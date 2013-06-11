/**
 * @author Juan Manuel Nieto-Moreno
 */
package webServices.tourGuide.domainLogic.model.user;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum RoleUser {

    /**
     * An user as administrator will have a complete control over the
     * application.
     */
    @XmlElement(name = "admin")
    Administrator,

    /**
     * An user as Collaborator will have a wide control over the application,
     * but it will not able to use the user management.
     */
    @XmlElement(name = "collaborator")
    Collaborator,

    /**
     * A Consumer will just be able to have a look of the application.
     */
    @XmlElement(name = "consumer")
    Consumer
}