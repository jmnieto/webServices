package webServices.tourGuide.domainLogic.services.implementations.location;


import java.util.ArrayList;
import java.util.List;

import webServices.tourGuide.domainLogic.model.location.Location;
import webServices.tourGuide.domainLogic.services.interfaces.location.LocationService;
import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLocationDTO;
import webServices.tourGuide.resources.interfaces.location.IResourcesLocation;
import webServices.tourGuide.domainLogic.services.rest.*;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class LocationServiceImpl extends RemoteServiceServlet implements LocationService {

	

	// logger
	//final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	private static final long serialVersionUID = 4544019606067110469L;

	private IResourcesLocation locationManager;
	
	public void init(){
		//logger.info("Initialising the user management service...");
		
		//It has to be changed to a REST consumer
		locationManager = new Rest();
		
		//logger.info("The user management service was successfully initialised.");
	}

	@Override
	public ResponseLocationDTO location() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<LocationDTO> getLocations(LocationDTO initialLocation) {

		
		List<Location> result = new ArrayList<Location>();
		List<LocationDTO> resultDTO = new ArrayList<LocationDTO>();
		
		result = locationManager.getLocations(convertLocation(initialLocation));
		
		for(int i = 0; i < result.size(); i++){
			resultDTO.add(convertLocationDTO(result.get(i)));
	}
		
		return resultDTO;
	}
	
	public Location convertLocation(LocationDTO dto){
		Location location = new Location();
		
		location.setDescription(dto.getDescription());
		location.setName(dto.getName());
		location.setLat(dto.getLat());
		location.setLng(dto.getLng());
		location.setLink(dto.getLink());
		location.setId(dto.getId());
		
		return location;
	}

	@Override
	public List<LocationDTO> getLocations(String id) {
		
		List<LocationDTO> locationsDTO = new ArrayList<LocationDTO>();
		List<Location> listLocation = locationManager.getLocations(id);
		
		for(int i = 0; i < listLocation.size(); i++){
				locationsDTO.add(convertLocationDTO(listLocation.get(i)));
		}
		
		return locationsDTO;
	}
	
	public LocationDTO convertLocationDTO(Location location){
		LocationDTO locDTO = new LocationDTO();
		
		locDTO.setId(location.getId());
		locDTO.setLat(location.getLat());
		locDTO.setLng(location.getLng());
		locDTO.setLink(location.getLink());
		locDTO.setName(location.getName());
		locDTO.setDescription(location.getDescription());
		
		return locDTO;
		
	}

	@Override
	public void setLat(String id, String lat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLng(String id, String Lng) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLocation(String idUser, List<LocationDTO> loc) {
		
		List<Location> locations = new ArrayList<Location>();
		boolean result = false;
		
		for(int i = 0; i < loc.size(); i++){
			locations.add(convertLocation(loc.get(i)));
		}
		
		locationManager.deleteLocationByUserId(idUser, locations);
		
	}

	@Override
	public LocationDTO addLocation(String userId, String location) {
		
		Location loc = new Location();
		//loc = convertLocation(location);
		
		loc = locationManager.addLocation(location, userId);
		
		return convertLocationDTO(loc);
		
	}


}
