package webServices.tourGuide.domainLogic.model.user;

/**
 * @author Juan Manuel Nieto-Moreno
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Attribute {

    private String name;

    private String value;

    @Deprecated
    public Attribute() {

    }

    public Attribute(String name, String value) {
	this.name = name;
	this.value = value;
    }

    /**
     * @return the name
     */
    @XmlElement(name = "name")
    public String getName() {
	return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	if ((name == null) || name.isEmpty()) {
	    throw new IllegalArgumentException("Argumento nulo.");
	}

	this.name = name;
    }

    /**
     * @return the value
     */
    @XmlElement(name = "value")
    public String getValue() {
	return this.value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
	if ((value == null) || value.isEmpty()) {
	    throw new IllegalArgumentException("Argumento nulo.");
	}

	this.value = value;
    }
}