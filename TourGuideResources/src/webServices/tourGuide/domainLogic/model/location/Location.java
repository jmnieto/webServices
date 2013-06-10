/**
 * @author Walter Gugenberger
 * @date 30.05.2013 15:34:51
 * @version
 * @name UsersGestion.users.domainLogic.business.Location.java
 * @description Location models a location
 */
package webServices.tourGuide.domainLogic.model.location;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class Location.
 */
@XmlRootElement
public class Location {

    /** The id. */
    private String id;

    /** The name. */
    private String name;

    /** The lat. */
    private String lat;

    /** The lng. */
    private String lng;

    /** The link. */
    private String link;

    /** The description. */
    private String description;

    /** The timestamp. */
    private String timestamp;

    /**
     * Instantiates a new location.
     */
    public Location() {
    }

    /**
     * Instantiates a new location.
     * 
     * @param id
     *            the id
     * @param name
     *            the name
     * @param lat
     *            the lat
     * @param lng
     *            the lng
     * @param link
     *            the link
     * @param description
     *            the description
     * @param timestamp
     *            the timestamp
     */
    public Location(String id, String name, String lat, String lng,
	    String link, String description, String timestamp) {
	super();
	this.id = id;
	this.name = name;
	this.lat = lat;
	this.lng = lng;
	this.link = link;
	this.description = description;
	this.timestamp = timestamp;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public String getId() {
	return this.id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return this.name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the new name
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the lat.
     * 
     * @return the lat
     */
    public String getLat() {
	return this.lat;
    }

    /**
     * Sets the lat.
     * 
     * @param lat
     *            the new lat
     */
    public void setLat(String lat) {
	this.lat = lat;
    }

    /**
     * Gets the lng.
     * 
     * @return the lng
     */
    public String getLng() {
	return this.lng;
    }

    /**
     * Sets the lng.
     * 
     * @param lng
     *            the new lng
     */
    public void setLng(String lng) {
	this.lng = lng;
    }

    /**
     * Gets the link.
     * 
     * @return the link
     */
    public String getLink() {
	return this.link;
    }

    /**
     * Sets the link.
     * 
     * @param link
     *            the new link
     */
    public void setLink(String link) {
	this.link = link;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
	return this.description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the timestamp.
     * 
     * @return the timestamp
     */
    public String getTimestamp() {
	return this.timestamp;
    }

    /**
     * Sets the timestamp.
     * 
     * @param timestamp
     *            the new timestamp
     */
    public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Location [id=" + this.id + ", name=" + this.name + ", lat="
		+ this.lat + ", lng=" + this.lng + ", link=" + this.link
		+ ", description=" + this.description + ", timestamp="
		+ this.timestamp + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = (prime * result)
		+ ((this.description == null) ? 0 : this.description.hashCode());
	result = (prime * result)
		+ ((this.id == null) ? 0 : this.id.hashCode());
	result = (prime * result)
		+ ((this.lat == null) ? 0 : this.lat.hashCode());
	result = (prime * result)
		+ ((this.link == null) ? 0 : this.link.hashCode());
	result = (prime * result)
		+ ((this.lng == null) ? 0 : this.lng.hashCode());
	result = (prime * result)
		+ ((this.name == null) ? 0 : this.name.hashCode());
	result = (prime * result)
		+ ((this.timestamp == null) ? 0 : this.timestamp.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Location other = (Location) obj;
	if (this.description == null) {
	    if (other.description != null) {
		return false;
	    }
	} else if (!this.description.equals(other.description)) {
	    return false;
	}
	if (this.id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!this.id.equals(other.id)) {
	    return false;
	}
	if (this.lat == null) {
	    if (other.lat != null) {
		return false;
	    }
	} else if (!this.lat.equals(other.lat)) {
	    return false;
	}
	if (this.link == null) {
	    if (other.link != null) {
		return false;
	    }
	} else if (!this.link.equals(other.link)) {
	    return false;
	}
	if (this.lng == null) {
	    if (other.lng != null) {
		return false;
	    }
	} else if (!this.lng.equals(other.lng)) {
	    return false;
	}
	if (this.name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!this.name.equals(other.name)) {
	    return false;
	}
	if (this.timestamp == null) {
	    if (other.timestamp != null) {
		return false;
	    }
	} else if (!this.timestamp.equals(other.timestamp)) {
	    return false;
	}
	return true;
    }

}
