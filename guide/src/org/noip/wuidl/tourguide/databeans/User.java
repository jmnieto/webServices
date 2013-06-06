/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:50
 * @version
 * @name guide.org.noip.wuidl.tourguide.databeans.User.java
 * @description User
 */
package org.noip.wuidl.tourguide.databeans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class User.
 */
@XmlRootElement
public class User {

	/** The id. */
	private String id;

	/** The username. */
	private String username;

	/** The pass. */
	private String pass;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 * 
	 * @param name
	 *            the name
	 * @param pass
	 *            the pass
	 */
	public User(String name, String pass) {
		setUsername(name);
		setPass(pass);
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
		if (this.id == null) {
			if ((id == null) || id.isEmpty()) {
				throw new IllegalArgumentException();
			}

			this.id = id;

		} else {
			throw new IllegalStateException();
		}
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		if ((username == null) || username.isEmpty()) {
			throw new IllegalArgumentException("Argumento nulo.");
		}
		this.username = username;
	}

	/**
	 * Gets the pass.
	 * 
	 * @return the pass
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * Sets the pass.
	 * 
	 * @param pass
	 *            the new pass
	 */
	public void setPass(String pass) {
		if ((pass == null) || pass.isEmpty()) {
			throw new IllegalArgumentException("Argumento nulo.");
		}
		this.pass = pass;
	}

}