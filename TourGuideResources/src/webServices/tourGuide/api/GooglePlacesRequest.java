/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version
 * @name guide.org.wuidl.noip.tourguide.GooglePlacesRequest.java
 * @description GooglePlacesRequest
 */
package webServices.tourGuide.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import webServices.tourGuide.domainLogic.model.location.Location;

/**
 * The Class GooglePlacesRequest.
 */
public class GooglePlacesRequest {

    /** The Constant GOOGLE_PLACES_API_KEY. */
    public static final String GOOGLE_PLACES_API_KEY = "AIzaSyB6evb58cLN5eZ2EiYLzIKBSDGKlD7NlPw";

    /** The Constant GOOGLE_PLACES_API_BASE. */
    public static final String GOOGLE_PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place/nearbysearch/";

    /**
     * Searches for POI within a certain radius of a position.
     * 
     * 
     * @param lat
     *            the lat
     * @param lng
     *            the lng
     * @param radius
     *            the radius
     * @return the list with POI represented as Place
     */
    public static List<Location> search(double lat, double lng, int radius) {
	List<Location> result = null;
	HttpURLConnection conn = null;
	StringBuilder jsonResults = new StringBuilder();
	try {
	    StringBuilder sb = new StringBuilder(GOOGLE_PLACES_API_BASE);
	    sb.append("json?");
	    sb.append("location=" + lat + "," + lng);
	    sb.append("&radius=" + radius);
	    sb.append("&sensor=false");
	    sb.append("&key=" + GOOGLE_PLACES_API_KEY);

	    URL url = new URL(sb.toString());
	    conn = (HttpURLConnection) url.openConnection();
	    InputStreamReader in = new InputStreamReader(conn.getInputStream());
	    int read;
	    char[] buffer = new char[1024];
	    while ((read = in.read(buffer)) != -1) {
		jsonResults.append(buffer, 0, read);
	    }
	} catch (MalformedURLException e) {
	    System.err.println("Error processing Places API URL");
	    return result;
	} catch (IOException e) {
	    System.err.println("Error connecting.");
	    return result;
	} finally {
	    if (conn != null) {
		conn.disconnect();
	    }
	}
	// TODO I am really sorry but I could not to add the library to find
	// JSONObject :( It is the Jersey library which is now attached

	//DOESNT WORK IF THIS CLASS IS IN A GWT PROJECT
	try {
	    JSONObject jsonObj = new JSONObject(jsonResults.toString());
	    JSONArray predsJsonArray = jsonObj.getJSONArray("results");
	    result = new ArrayList<Location>(predsJsonArray.length());
	    for (int i = 0; i < predsJsonArray.length(); i++) {
		Location place = new Location();
		place.setLat(predsJsonArray.getJSONObject(i)
			.getJSONObject("geometry").getJSONObject("location")
			.getString("lat"));
		place.setLng(predsJsonArray.getJSONObject(i)
			.getJSONObject("geometry").getJSONObject("location")
			.getString("lng"));
		place.setName(predsJsonArray.getJSONObject(i).getString("name"));
		place.setDescription(predsJsonArray.getJSONObject(i).getString(
			"vicinity"));
		place.setId(predsJsonArray.getJSONObject(i).getString("id"));
		result.add(place);
	    }
	} catch (JSONException e) {
	    e.printStackTrace();
	}
	return result;
    }

    // public static void main(String[] args) {
    // List<Place> list = search(-33.8670522, 151.1957362, 500);
    // System.out.println(list.toString());
    // }
}
