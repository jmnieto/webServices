package webServices.tourGuide.domainLogic.model.user;

/**
 * @author Juan Manuel Nieto-Moreno
 */


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private String id;

    private String username;

    private String pass;

    private RoleUser role;

    private boolean connect = false;

    //  private List<Attribute> attibutes = new ArrayList<Attribute>();

    public User() {
    }

    public User(String name, String pass, RoleUser role) {
	setUsername(name);
	setPass(pass);
	setRole(role);
    }

    @XmlElement(name = "id")
    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	if (this.id == null) {
	    if ((id == null) || id.isEmpty()) {
		id = "0";
	    }

	    this.id = id;

	} else {
	    throw new IllegalStateException(
		    "El id del usuario solo puede ser establecido una vez.");
	}
    }

    @XmlElement(name = "username")
    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	if ((username == null) || username.isEmpty()) {
	    throw new IllegalArgumentException("Argumento nulo.");
	}
	this.username = username;
    }

    @XmlElement(name = "pass")
    public String getPass() {
	return this.pass;
    }

    public void setPass(String pass) {
	if ((pass == null) || pass.isEmpty()) {
	    throw new IllegalArgumentException("Argumento nulo.");
	}
	this.pass = pass;
    }

    @XmlElement(name = "role")
    public RoleUser getRole() {
	return this.role;
    }

    public void setRole(RoleUser role) {
	if (role == null) {
	    throw new IllegalArgumentException("Argumento nulo.");
	}
	this.role = role;
    }

    @XmlElement(name = "connect")
    public boolean isConnect() {
	return this.connect;
    }

    public void setConnect(boolean connect) {
	this.connect = connect;
    }
    //
    //    /**
    //     * @return the attibutes
    //     */
    //    @XmlElementWrapper
    //    @XmlElement(name = "attributes")
    //    public List<Attribute> getAttibutes() {
    //	return this.attibutes;
    //    }
    //
    //    /**
    //     * @param attibutes
    //     *            the attibutes to set
    //     */
    //    public void setAttibutes(List<Attribute> attibutes) {
    //	if (attibutes == null) {
    //	    throw new IllegalArgumentException("Argumento nulo.");
    //	}
    //	this.attibutes = attibutes;
    //    }
}