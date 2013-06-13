package webServices.tourGuide.presentation.dataTransferObjects;

import java.io.Serializable;

public class UserDTO implements Serializable{


	private static final long serialVersionUID = 5983093283134331443L;

	
	
	private String  id;
	private String  name;
	private String 	pass;

	private boolean gestionUser;
	private boolean advancedFeatures;
	private boolean opinionView;
	
	public UserDTO() {
	}

	public UserDTO(String id, String name, boolean gestionUser,
			boolean advancedFeatures, boolean opinionView) {
		super();
		this.id = id;
		this.name = name;
		this.gestionUser = gestionUser;
		this.advancedFeatures = advancedFeatures;
		this.opinionView = opinionView;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGestionUser() {
		return gestionUser;
	}

	public void setGestionUser(boolean gestionUser) {
		this.gestionUser = gestionUser;
	}

	public boolean isAdvancedFeatures() {
		return advancedFeatures;
	}

	public void setAdvancedFeatures(boolean advancedFeatures) {
		this.advancedFeatures = advancedFeatures;
	}

	public boolean isOpinionView() {
		return opinionView;
	}

	public void setOpinionView(boolean opinionView) {
		this.opinionView = opinionView;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (advancedFeatures ? 1231 : 1237);
		result = prime * result + (gestionUser ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (opinionView ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (advancedFeatures != other.advancedFeatures)
			return false;
		if (gestionUser != other.gestionUser)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (opinionView != other.opinionView)
			return false;
		return true;
	}
	
	
	
}
