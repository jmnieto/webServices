package webServices.tourGuide.presentation.client.controller;

import webServices.tourGuide.domainLogic.services.interfaces.user.UsersService;
import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.controller.prototype.AppController;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.events.NavigationEventHandler;
import webServices.tourGuide.presentation.client.presenters.LoginPresenter;
import webServices.tourGuide.presentation.client.presenters.MapPresenter;
import webServices.tourGuide.presentation.client.presenters.PrincipalPresenter;
import webServices.tourGuide.presentation.client.views.login.LoginView;
import webServices.tourGuide.presentation.client.views.principal.PrincipalView;
import webServices.tourGuide.presentation.client.views.map.MapView;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class TourGuideController extends AppController implements ValueChangeHandler<String>{
	
	private LoginPresenter.Display loginDisplay;
	private PrincipalPresenter.Display principalDisplay;
	private MapPresenter.Display mapDisplay;
	
	public TourGuideController(){
		//Establecemos el item principal
		setMainItem("TourGuide");
	}
	
	@Override
	public void loadController() {
		loadHandlers();
	}
	
	@Override
	public void disposeController() {
		final UsersServiceAsync user = UsersService.Util.getInstance();
		
		user.disconnect(new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	
	/**
	 * Se estableceran todos los manejadores para las senyales que se enviaran al bus.
	 */
	private void loadHandlers(){
		//nos establecemos como observadores del bus.
		History.addValueChangeHandler(this);
		
		getEventBus().addHandler(NavigationEvent.TYPE, new NavigationEventHandler() {
			
			@Override
			public void onNavigation(NavigationEvent event) {
				switch (event.getDest()) {
				
				case Login:
					goLogin();
					break;
				case Principal:
					goPrincipal();
					break;
				case Map:
					goMap();
				//	break;
				default:
					//TODO ERROR Screen
					break;
				}
			}
		});
	}
	
	private void goLogin() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				if(loginDisplay == null){
					loginDisplay = new LoginView();
				}
				
				if(getContainer() != null){
					getContainer().clear();
				}
				
				setPrincipal(new LoginPresenter(getEventBus(), loginDisplay, UsersService.Util.getInstance()), loginDisplay.asWidget());
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO ERROR screen.
			}
		});
	}
	
	private void goPrincipal() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				// Carga de la pantalla principal...
				if (principalDisplay == null) {
					principalDisplay = new PrincipalView();
		        }
				
				setPrincipal( new PrincipalPresenter(getEventBus(), principalDisplay), principalDisplay.asWidget(), principalDisplay.getCentralPanel());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO pantalla de error.
			}
		});
	}
	
	private void goMap() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				// Carga de la pantalla principal...
				if (mapDisplay == null) {
					//mapDisplay = new MapView();
		        }
				
				setPrincipal( new MapPresenter(getEventBus(), mapDisplay), mapDisplay.asWidget(), mapDisplay.getCentralPanel());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO pantalla de error.
			}
		});
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		
		if (token != null) {
			
			if (token.equals(getMainItem())) {
				final UsersServiceAsync user = UsersService.Util.getInstance();
				
				user.getUserConnected(new AsyncCallback<UserDTO>() {
					
					@Override
					public void onSuccess(UserDTO result) {
						if(result != null){
							user.connectUser(new AsyncCallback<Boolean>() {
								
								@Override
								public void onSuccess(Boolean result) {
									if(result.booleanValue()){
										goPrincipal();
									}else{
										goLogin();
									}
								}
								
								@Override
								public void onFailure(Throwable caught) {
									goLogin();
								}
							});
						}else{
							goLogin();
						}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						goLogin();
					}
				});
			} 
		}
	}
}
