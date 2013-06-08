package webServices.tourGuide.presentation.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class NavigationEvent extends GwtEvent<NavigationEventHandler>{
	
	public enum Navigation{
		Login,
		Principal,
		Map,
		Register,
		//Error,
		//About,
		//MyPlaces,
		//configuration,
	}
	
	public static Type<NavigationEventHandler> TYPE = new Type<NavigationEventHandler>();
	private final Navigation dest;
	
	public NavigationEvent(Navigation dest){
		this.dest   = dest;
	}
	
	public NavigationEvent(Navigation dest, String domain) {
		this.dest 	= dest;
	}
  
	public Navigation getDest() {
		return dest; 
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
