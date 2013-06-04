/**
 * @author Juan Manuel Nieto-Moreno
 */
package webServices.tourGuide.domainLogic.model.user;

public class Attribute {

	private String name;
	private String value;
	
	public Attribute(String name, String value) {
		this.name  = name;
		this.value = value;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name == null || name.isEmpty()){
			throw new IllegalArgumentException("Argumento nulo.");
		}
		
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		if(value == null || value.isEmpty()){
			throw new IllegalArgumentException("Argumento nulo.");
		}
		
		this.value = value;
	}
}