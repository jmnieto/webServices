lpackage webServices.tourGuide.rest.client;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import webServices.tourGuide.domainLogic.model.location.Location;
import webServices.tourGuide.domainLogic.model.user.RoleUser;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.resources.interfaces.location.IResourcesLocation;
import webServices.tourGuide.resources.interfaces.user.IResourcesUsers;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class Rest implements IResourcesLocation, IResourcesUsers {
    private Client client;
    private WebResource resource;
    private static final String REST_PATH = "http://wuidl.no-ip.org:8080/guide/rest/";
    private static final String LOC_PATH = "location/";
    private static final String USR_PATH = "user/";

    public Rest() {
	this.client = Client.create(new DefaultClientConfig());
	this.resource = this.client.resource(REST_PATH);

    }

    @Override
    public User addUser(String name, String pass, RoleUser role) {
	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
	map.putSingle("name", name);
	map.putSingle("pwd", pass);
	ClientResponse response = this.resource.path(USR_PATH).path("addUser")
		.queryParams(map).type(MediaType.TEXT_PLAIN)
		.accept("application/json").post(ClientResponse.class);
	return response.getEntity(User.class);
    }

    @Override
    public User addUser(User user) throws ExistingUserException {
	ClientResponse response = this.resource.path(USR_PATH)
		.path("addUserObject").type("application/json")
		.accept("application/json").post(ClientResponse.class, user);
	return response.getEntity(User.class);
    }

    @Override
    public void delUser(User user) {
	this.resource.path(USR_PATH).path("deleteUser")
	.type("application/json").accept("application/json").post(user);

    }

    @Override
    public void synchronizeUser(User user) {
	this.resource.path(USR_PATH).path("syncUser").type("application/json")
	.accept("application/json").post(user);

    }

    @Override
    public User getUser(String nameUser) {
	ClientResponse response = this.resource.path(USR_PATH).path("getUser")
		.type("application/json").accept("application/json")
		.post(ClientResponse.class, nameUser);
	return response.getEntity(User.class);
    }

    @Override
    public List<User> getUsers() {
	ClientResponse response = this.resource.path(USR_PATH).path("getUsers")
		.accept("application/json").post(ClientResponse.class);
	return null;// TODO
    }

    @Override
    public boolean existUser(String nameUser) {
	ClientResponse response = this.resource.path("USR_PATH")
		.path("existUser").type("text/plain")
		.accept("application/json").post(ClientResponse.class);
	return response.getEntity(Boolean.class);
    }

    @Override
    public boolean checkPassword(String nameUser, String password) {
	ClientResponse response = this.resource.path("USR_PATH")
		.path("checkPassword").type("text/plain")
		.accept("application/json").post(ClientResponse.class);
	return response.getEntity(Boolean.class);
    }

    @Override
    public void setPassword(User user, String newPassword) {
	this.resource.path("USR_PATH").path("setPwd")
	.queryParam("pwd", newPassword).accept("application/json")
	.post(ClientResponse.class, user);

    }

    @Override
    public void setName(User user, String newName) {
	this.resource.path("USR_PATH").path("setName")
	.queryParam("pwd", newName).accept("application/json")
	.post(ClientResponse.class, user);

    }

    @Override
    public Location addLocation(Location loc, String userId) {
	ClientResponse response = this.resource.path(LOC_PATH)
		.path("addLocation").queryParam("id", userId)
		.type("application/json").accept("application/json")
		.post(ClientResponse.class, loc);
	return response.getEntity(Location.class);
    }

    @Override
    public Location addLocation(String name, String lat, String lng,
	    String link, String description, String userId) {
	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
	map.putSingle("name", name);
	map.putSingle("lat", lat);
	map.putSingle("link", link);
	map.putSingle("description", description);
	map.putSingle("id", userId);
	map.putSingle("lng", lng);
	ClientResponse response = this.resource.path(LOC_PATH)
		.path("addLocation").queryParams(map)
		.post(ClientResponse.class);
	return response.getEntity(Location.class);
    }

    @Override
    public void deleteLocation(Location loc) {
	this.resource.path(LOC_PATH).path("deleteLocation")
	.type("application/json").post(ClientResponse.class, loc);

    }

    @Override
    public void deleteLocation(String name) {
	this.resource.path(LOC_PATH).path("deleteLocation")
	.queryParam("name", name).type("text/plain")
	.post(ClientResponse.class);

    }

    @Override
    public void updateLocation(String name, String description, String link) {
	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
	map.putSingle("name", name);
	map.putSingle("description", description);
	map.putSingle("link", link);
	this.resource.path(LOC_PATH).path("updateLocation").queryParams(map)
	.type("text/plain").post();

    }

    @Override
    public List<Location> getLocations(String id) {
	ClientResponse response = this.resource.path(LOC_PATH)
		.path("getLocations").queryParam("id", id)
		.accept("application/json").post(ClientResponse.class);
	return null;// TODO
    }

    @Override
    public List<Location> getLocations(Location myLocalization) {
	// TODO Auto-generated method stub
    	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
    	map.putSingle("name", myLocalization.getName());
    	map.putSingle("lat", myLocalization.getLat());
    	map.putSingle("link", myLocalization.getLink());
    	map.putSingle("description", myLocalization.getDescription());
    	map.putSingle("id", myLocalization.getId());
    	map.putSingle("lng", myLocalization.getLng());
    	ClientResponse response = this.resource.path(LOC_PATH).path("getLocations")
    			.queryParam(map).accept("application/json").post(ClientResponse.class);
	return null; //TODO response.getEntity(..);
    }

    @Override
    public void deleteLocationByUserId(String idUser, List<Location> loc) {
	this.resource.path(LOC_PATH).path("deleteLocationByUserId")
	.queryParam("id", idUser).post(loc);

    }

    @Override
    public void deleteLocation(List<Location> list) {
	this.resource.path(LOC_PATH).path("deleteLocations")
	.type("application/json").post(list);

    }

    @Override
    public Location addLocation(String city, String userId) {
	Location loc = new Location();
	loc.setName(city);
	return this.addLocation(loc, userId);
    }

}
