package webServices.tourGuide.presentation.client.controller;

import webServices.tourGuide.domainLogic.services.interfaces.user.UsersService;
import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.controller.prototype.AppController;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.events.NavigationEventHandler;
import webServices.tourGuide.presentation.client.presenters.ConfigurationPresenter;
import webServices.tourGuide.presentation.client.presenters.ErrorPresenter;
import webServices.tourGuide.presentation.client.presenters.LoginPresenter;
import webServices.tourGuide.presentation.client.presenters.MapPresenter;
import webServices.tourGuide.presentation.client.presenters.MyPlacesPresenter;
import webServices.tourGuide.presentation.client.presenters.PrincipalPresenter;
import webServices.tourGuide.presentation.client.presenters.RegisterPresenter;
import webServices.tourGuide.presentation.client.views.configuration.ConfigurationView;
import webServices.tourGuide.presentation.client.views.login.LoginView;
import webServices.tourGuide.presentation.client.views.map.MapView;
import webServices.tourGuide.presentation.client.views.myPlaces.MyPlacesView;
import webServices.tourGuide.presentation.client.views.principal.PrincipalView;
import webServices.tourGuide.presentation.client.views.register.RegisterView;
import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class TourGuideController extends AppController implements ValueChangeHandler<String>{
	
	private LoginPresenter.Display loginDisplay;
	private RegisterPresenter.Display registerDisplay;
	private PrincipalPresenter.Display principalDisplay;
	private MapPresenter.Display mapDisplay;
	private MyPlacesPresenter.Display myPlacesDisplay;
	private ErrorPresenter.Display errorDisplay;
	private ConfigurationPresenter.Display ConfigurationDisplay;
	
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
				
				LocationDTO obj = event.getLocation();
				switch (event.getDest()) {
				
				case Login:
					goLogin();
					break;
				case Principal:
					goPrincipal();
					break;
				case Map:
					goMap(obj);
					break;
				case MyPlaces:
					goMyPlaces();
					break;
				case Register:
					goRegister();
					break;
				case Configuration:
					goConfiguration();
					break;
				case About:
					//goAbout();
					break;
				default:
					setPresenterActive(new ErrorPresenter(getEventBus(), errorDisplay), errorDisplay.asWidget());
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
	
	private void goRegister() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				if(registerDisplay == null){
					registerDisplay = new RegisterView();
				}
				
				if(getContainer() != null){
					getContainer().clear();
				}
				
				setPrincipal(new RegisterPresenter(getEventBus(), registerDisplay, UsersService.Util.getInstance()), registerDisplay.asWidget());
				
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
	
	private void goMap(final LocationDTO obj) {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				// Carga de la pantalla principal...
				if (mapDisplay == null) {
					mapDisplay = new MapView();
		        }
				
				//setPrincipal( new MapPresenter(getEventBus(), mapDisplay), mapDisplay.asWidget(), mapDisplay.getPanelContainer());
				if(obj == null){
					setPresenterActive(new MapPresenter(getEventBus(), mapDisplay), mapDisplay.asWidget());
				}else{
					setPresenterActive(new MapPresenter(getEventBus(), mapDisplay, obj), mapDisplay.asWidget());
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO pantalla de error.
			}
		});
	}
	
	private void goMyPlaces() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				// Carga de la pantalla principal...
				if (myPlacesDisplay == null) {
					myPlacesDisplay = new MyPlacesView();
		        }
				
				//setPrincipal( new MapPresenter(getEventBus(), mapDisplay), mapDisplay.asWidget(), mapDisplay.getPanelContainer());
				setPresenterActive(new MyPlacesPresenter(getEventBus(), myPlacesDisplay), myPlacesDisplay.asWidget());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO pantalla de error.
				setPresenterActive(new ErrorPresenter(getEventBus(), errorDisplay), errorDisplay.asWidget());
			}
		});
	}
	
	private void goConfiguration() {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				// Carga de la pantalla principal...
				if (ConfigurationDisplay == null) {
					ConfigurationDisplay = new ConfigurationView();
		        }
				
				//setPrincipal( new MapPresenter(getEventBus(), mapDisplay), mapDisplay.asWidget(), mapDisplay.getPanelContainer());
				setPresenterActive(new ConfigurationPresenter(getEventBus(), ConfigurationDisplay), ConfigurationDisplay.asWidget());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO pantalla de error.
				setPresenterActive(new ErrorPresenter(getEventBus(), errorDisplay), errorDisplay.asWidget());
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
