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

    public User() {
    }

    public User(String name, String pass) {
	setUsername(name);
	setPass(pass);
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

    @Override
    public String toString() {
	return "User [id=" + this.id + ", username=" + this.username + ", pass=" + this.pass
		+ "]";
    }

}