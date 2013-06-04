package webServices.tourGuide.presentation.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface NavigationEventHandler extends EventHandler {
  void onNavigation(NavigationEvent event);
}
