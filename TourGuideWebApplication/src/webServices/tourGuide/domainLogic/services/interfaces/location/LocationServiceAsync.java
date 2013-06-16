package webServices.tourGuide.domainLogic.services.interfaces.location;



import java.util.List;

import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLoginDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LocationServiceAsync {

	void location(AsyncCallback<ResponseLocationDTO> callback);

	void deleteLocation(String idUser, List<LocationDTO> loc,
			AsyncCallback<Void> callback);

	void setLat(String id, String lat, AsyncCallback<Void> callback);

	void setLng(String id, String Lng, AsyncCallback<Void> callback);

	void getLocations(String id, AsyncCallback<List<LocationDTO>> callback);

	void getLocations(LocationDTO initialLocation,
			AsyncCallback<List<LocationDTO>> callback);

	void addLocation(String city, String userId,
			AsyncCallback<LocationDTO> callback);



}
