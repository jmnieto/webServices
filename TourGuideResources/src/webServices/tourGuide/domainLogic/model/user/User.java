/**
 * @author Juan Manuel Nieto-Moreno
 */
package webServices.tourGuide.domainLogic.model.user;

import java.util.ArrayList;
import java.util.List;


public class User {

	private String 	 id;
	private String 	 username;
	private String 	 pass;
	private RoleUser role;
	private boolean  connect = false;

	private List<Attribute> attibutes = new ArrayList<Attribute>();
	
	public User() {}
	
	public User(String name, String pass, RoleUser role) {
		setUsername(name);
		setPass(pass);
		setRole(role);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(this.id == null){
			if(id == null || id.isEmpty()){
				throw new IllegalArgumentException("Argumento nulo.");
			}
			
			this.id = id;
			
		}else{
			throw new IllegalStateException("El id del usuario solo puede ser establecido una vez.");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username == null || username.isEmpty()){
			throw new IllegalArgumentException("Argumento nulo.");
		}
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		if(pass == null || pass.isEmpty()){
			throw new IllegalArgumentException("Argumento nulo.");
		}
		this.pass = pass;
	}

	public RoleUser getRole() {
		return role;
	}

	public void setRole(RoleUser role) {
		if(role == null){
			throw new IllegalArgumentException("Argumento nulo.");
		}
		this.role = role;
	}

	public boolean isConnect() {
		return connect;
	}
	public void setConnect(boolean connect) {
		this.connect = connect;
	}

	/**
	 * @return the attibutes
	 */
	public List<Attribute> getAttibutes() {
		return attibutes;
	}

	/**
	 * @param attibutes the attibutes to set
	 */
	public void setAttibutes(List<Attribute> attibutes) {
		if(attibutes == null){
			throw new IllegalArgumentException("Argumento nulo.");
		}
		this.attibutes = attibutes;
	}
}