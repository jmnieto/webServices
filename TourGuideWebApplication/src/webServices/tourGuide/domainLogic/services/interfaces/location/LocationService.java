package webServices.tourGuide.domainLogic.services.interfaces.location;

import java.util.List;

import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLocationDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * Servicio relacionado con la gestion de usuarios.
 * Futuros usuarios administradores.
 * @author bogulin
 *
 */
@RemoteServiceRelativePath("location")
public interface LocationService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static LocationServiceAsync instance;
		public static LocationServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(LocationService.class);
			}
			return instance;
		}
	}
	
	
	public ResponseLocationDTO location();
	
	//Obtain location/s
	public List<LocationDTO> getLocations(String id);
	public List<LocationDTO> getLocations(LocationDTO initialLocation);
	
	//Set the the current location from geoLocalization
	public void setLat(String id, String lat);
	public void setLng(String id, String Lng);
	
	
	//Delete a location from MyPlaces
	public void deleteLocation(String idUser, List<LocationDTO> loc);
	
	//Add a new location
	public LocationDTO addLocation(String userId, String location);
	
}
