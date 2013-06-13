package webServices.tourGuide.presentation.client.events;

import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;

import com.google.gwt.event.shared.GwtEvent;

public class NavigationEvent extends GwtEvent<NavigationEventHandler>{
	
	public enum Navigation{
		Login,
		Principal,
		Map,
		Register,
		Error,
		About,
		MyPlaces,
		Configuration,
	}
	
	public static Type<NavigationEventHandler> TYPE = new Type<NavigationEventHandler>();
	private final Navigation dest;
	private final LocationDTO location;
	
	public NavigationEvent(Navigation dest){
		this.dest     = dest;
		this.location = null;
	}
	
	public NavigationEvent(Navigation dest, LocationDTO location) {
		this.dest 	  = dest;
		this.location = location;
	}
  
	public Navigation getDest() {
		return dest; 
	}
	
	public LocationDTO getLocation() {
		return location;
	}

	@Override
	public Type<NavigationEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	@Override
	protected void dispatch(NavigationEventHandler handler) {
		handler.onNavigation(this);
	}

	
}
