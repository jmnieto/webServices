/**
 * @author Walter Gugenberger
 * @date 13.06.2013 22:36:15
 * @version
 * @name TourGuideResources.webServices.tourGuide.rest.client.Rest.java
 * @description Rest
 */
package webServices.tourGuide.rest.client;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import webServices.tourGuide.domainLogic.model.location.Location;
import webServices.tourGuide.domainLogic.model.user.User;
import webServices.tourGuide.resources.exceptions.ExistingUserException;
import webServices.tourGuide.resources.interfaces.location.IResourcesLocation;
import webServices.tourGuide.resources.interfaces.user.IResourcesUsers;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * The Class Rest.
 */
public class Rest implements IResourcesLocation, IResourcesUsers {

    /** The client. */
    private Client client;

    /** The resource. */
    private WebResource resource;/* 10.0.0.5 */

    /** The Constant REST_PATH. */
    private static final String REST_PATH = "http://10.0.0.5:8080/guide/rest/";

    /** The Constant LOC_PATH. */
    private static final String LOC_PATH = "location/";

    /** The Constant USR_PATH. */
    private static final String USR_PATH = "user/";

    /**
     * Instantiates a new rest.
     */
    public Rest() {
	ClientConfig config = new DefaultClientConfig();
	config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
		Boolean.TRUE);

	this.client = Client.create(config);
	this.resource = this.client.resource(UriBuilder.fromUri(REST_PATH)
		.build());

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#addUser
     * (java.lang.String, java.lang.String)
     */
    @Override
    public User addUser(String name, String pass) {
	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
	map.putSingle("name", name);
	map.putSingle("pwd", pass);
	User u = this.resource.path(USR_PATH).path("addUser").queryParams(map)
		.type(MediaType.TEXT_PLAIN).accept("application/json")
		.post(User.class);
	return u;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#addUser
     * (webServices.tourGuide.domainLogic.model.user.User)
     */
    @Override
    public User addUser(User user) throws ExistingUserException {
	return this.resource.path(USR_PATH).path("addUserObject")
		.type("application/json").accept("application/json")
		.post(User.class, user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#delUser
     * (webServices.tourGuide.domainLogic.model.user.User)
     */
    @Override
    public void delUser(User user) {
	this.resource.path(USR_PATH).path("deleteUser")
	.type("application/json").accept("application/json").post(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see webServices.tourGuide.resources.interfaces.user.IResourcesUsers#
     * synchronizeUser(webServices.tourGuide.domainLogic.model.user.User)
     */
    @Override
    public void synchronizeUser(User user) {
	this.resource.path(USR_PATH).path("syncUser").type("application/json")
	.put(user);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#getUser
     * (java.lang.String)
     */
    @Override
    public User getUser(String nameUser) {
	return this.resource.path(USR_PATH).path("getUser/" + nameUser)
		.type("text/plain").accept("application/json").get(User.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#getUsers
     * ()
     */
    @Override
    public List<User> getUsers() {
	return this.resource.path(USR_PATH).path("getUsers")
		.accept("application/json").get(new GenericType<List<User>>() {
		});

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#existUser
     * (java.lang.String)
     */
    @Override
    public boolean existUser(String nameUser) {
	return this.resource.path(USR_PATH).path("existUser")
		.queryParam("name", nameUser).type("text/plain")
		.accept("application/json").get(Boolean.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#checkPassword
     * (java.lang.String, java.lang.String)
     */
    @Override
    public boolean checkPassword(String nameUser, String password) {
	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
	map.putSingle("name", nameUser);
	map.putSingle("pwd", password);
	return this.resource.path(USR_PATH).path("checkPassword")
		.queryParams(map).type("text/plain").accept("application/json")
		.get(Boolean.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#setPassword
     * (webServices.tourGuide.domainLogic.model.user.User, java.lang.String)
     */
    @Override
    public void setPassword(User user, String newPassword) {
	this.resource.path(USR_PATH).path("setPwd")
	.queryParam("pwd", newPassword).type("application/json")
	.accept("application/json").post(user);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.user.IResourcesUsers#setName
     * (webServices.tourGuide.domainLogic.model.user.User, java.lang.String)
     */
    @Override
    public void setName(User user, String newName) {
	this.resource.path(USR_PATH).path("setName")
	.queryParam("user", newName).type("text/plain").post(user);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #addLocation(webServices.tourGuide.domainLogic.model.location.Location,
     * java.lang.String)
     */
    @Override
    public List<Location> addLocation(Location loc, String userId) {
	return this.resource.path(LOC_PATH).path("addLocationObject")
		.type("application/json").accept("application/json")
		.post(new GenericType<List<Location>>() {
		}, loc);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #addLocation(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
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
	map.putSingle("userId", userId);
	return this.resource.path(LOC_PATH).path("addLocation")
		.queryParams(map).type("text/plain").accept("application/json")
		.post(Location.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #getLocations(java.lang.String)
     */
    @Override
    public List<Location> getLocations(String userId) {
	return this.resource.path(LOC_PATH).path("getLocationsByUserId")
		.queryParam("id", userId)
		.get(new GenericType<List<Location>>() {
		});
    }

    // idk how to implement that. we cannot provide this feature
    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #getLocations(webServices.tourGuide.domainLogic.model.location.Location)
     */
    @Override
    public List<Location> getLocations(Location myLocalization) {
	return this.resource.path(LOC_PATH).path("getLocationsByMyLoc")
		.type("application/json").accept("application/json")
		.post(new GenericType<List<Location>>() {
		}, myLocalization);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #deleteLocation
     * (webServices.tourGuide.domainLogic.model.location.Location)
     */
    @Override
    public void deleteLocation(Location loc) {
	this.resource.path(LOC_PATH).path("deleteLocation")
	.type("application/json").post(loc);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #deleteLocation(java.lang.String)
     */
    @Override
    public void deleteLocation(String name) {
	this.resource.path(LOC_PATH).path("deleteLocationByName")
	.queryParam("name", name).type("text/plain")
	.post(ClientResponse.class);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #updateLocation(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void updateLocation(String name, String description, String link) {
	MultivaluedMap<String, String> map = new MultivaluedMapImpl();
	map.putSingle("name", name);
	map.putSingle("description", description);
	map.putSingle("link", link);
	this.resource.path(LOC_PATH).path("updateLocation").queryParams(map)
	.type("text/plain").post();

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #deleteLocationByUserId(java.lang.String, java.util.List)
     */
    @Override
    public void deleteLocationByUserId(String idUser, List<Location> loc) {
	this.deleteUserLocations(idUser, loc);

    }

    /**
     * Delete user locations.
     * 
     * @param idUser
     *            the id user
     * @param list
     *            the list
     */
    private void deleteUserLocations(String idUser, List<Location> list) {
	for (Location l : list) {
	    this.resource.path(LOC_PATH).path("deleteLocations")
	    .queryParam("id", idUser).type("application/json").post(l);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #deleteLocation(java.util.List)
     */
    @Override
    public void deleteLocation(List<Location> list) {
	for (Location l : list) {
	    this.deleteLocation(l);
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * webServices.tourGuide.resources.interfaces.location.IResourcesLocation
     * #addLocation(java.lang.String, java.lang.String)
     */
    @Override
    public Location addLocation(String city, String userId) {
	Location loc = new Location();
	loc.setName(city);
	return this.addLocation(city, "", "", "", "", userId);
    }

    /* ************* API calls */

    /**
     * Gets all wikipedia articles according to a location within a 1500 meter
     * radius and a limit of 10 articles.
     * 
     * @param myLocalization
     *            the my localization
     * @return the articles
     */
    public List<Location> getArticles(Location myLocalization) {
	return this.resource.path(LOC_PATH).path("getWikiByMyLoc")
		.type("application/json").accept("application/json")
		.post(new GenericType<List<Location>>() {
		}, myLocalization);
    }

}
