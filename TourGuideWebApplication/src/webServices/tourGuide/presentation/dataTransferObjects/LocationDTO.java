package webServices.tourGuide.presentation.dataTransferObjects;

import java.io.Serializable;

import com.google.gwt.maps.client.geom.LatLng;

public class LocationDTO implements Serializable{

	private static final long serialVersionUID = -3921482429598853322L;
	
	private String id;
	private String lat;
	private String lng;
	private String name;
	private String link;
	private String description;
	
	public LocationDTO(){
	}
		
	public LocationDTO (String id, String lat, String lng, String name, String link, String description){
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.link = link;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		



}
