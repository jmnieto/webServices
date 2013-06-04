package webServices.tourGuide.presentation.entryPoint;

import webServices.tourGuide.presentation.client.controller.TourGuideController;
import webServices.tourGuide.presentation.client.controller.prototype.IAppController;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TourGuide implements EntryPoint {
	
	public void onModuleLoad() {
	    IAppController appViewer = new TourGuideController();
	    appViewer.go(RootPanel.get("contains"), new HandlerManager(null));
	}
}
