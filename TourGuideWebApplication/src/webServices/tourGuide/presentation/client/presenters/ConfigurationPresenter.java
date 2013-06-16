package webServices.tourGuide.presentation.client.presenters;

import java.util.ArrayList;
import java.util.List;

import webServices.tourGuide.domainLogic.services.interfaces.location.LocationServiceAsync;
import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.presenters.prototype.Presenter;
import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.maps.client.InfoWindow;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.event.MarkerClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geom.Point;
import com.google.gwt.maps.client.geom.Size;
import com.google.gwt.maps.client.overlay.Icon;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
//MAPS
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.Position.Coordinates;
import com.google.gwt.geolocation.client.PositionError;

//import com.google.code.gwt.geolocation.client.Coordinates;
//import com.google.code.gwt.geolocation.client.Geolocation;
//import com.google.code.gwt.geolocation.client.Position;
//import com.google.code.gwt.geolocation.client.PositionCallback;
//import com.google.code.gwt.geolocation.client.PositionError;
//import com.google.code.gwt.geolocation.client.PositionOptions;




public class ConfigurationPresenter extends Presenter{
	
	
	public interface Display{
		public Widget 				asWidget();
		
		public void clear();
		
		//MAP-TABLE

		public String 	getNameText();
		public String 	getPass1Text();
		public String 	getPass2Text();
		
		public void		setNameText(String Name);
		public void 	setVisibleError(boolean visible);
		public void		setVisibleError(boolean visible, String text);
		
		public HasClickHandlers getButtonDeleteUser();
		public HasClickHandlers getButtonUpdateUser();
		

	}
	
	private HandlerManager 	eventBus;
	private Display 		view;
	
	private UsersServiceAsync usersManager;
	
//	Mensajes de Item optionviewAllopinion
	private final String DISABLE_OPTION = "Disable all opinion";
	private final String ENABLE_OPTION  = "Enable all opinion";
	

	private final MenuItem		  optionViewAllOpinion;
	
	
	
	public ConfigurationPresenter(HandlerManager eventBus, Display view) {
		
		this.eventBus  			  = eventBus;
		
		this.view	   			  = view;

		this.optionViewAllOpinion = new MenuItem("", optionAllViewOpinionCommand);
	}

	
	@Override
	public void init() {

		
		addHandlerRegistration(view.getButtonDeleteUser().addClickHandler(ButtonDeleteUser));
		addHandlerRegistration(view.getButtonUpdateUser().addClickHandler(ButtonUpdateUser));
	    
	}

	@Override
	public void start() {
		
		view.setVisibleError(false);
		
		loadUser();
		
		
	}
	
	@Override
	public void refresh() {
	}

	@Override
	public void finish() {
		//view.clear();
	}
	
	
	public void loadUser(){
		
		/*TEST ON*/
//		UserDTO user = new UserDTO();
//		user.setName("Juan Luis");
//		user.setPass("1234");
//		view.setNameText(user.getName());
		/*TEST OFF*/

		usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
			
			@Override
			public void onSuccess(UserDTO result) {
				view.setNameText(result.getName());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
				
			}
		});
		
		
	}
	
	ClickHandler ButtonDeleteUser = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			
			
			/*DELETE FROM OUR DB*/
			usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
				
				@Override
				public void onSuccess(UserDTO result) {
					usersManager.deleteUser(result.getName(), new AsyncCallback<Void>() {
						
						@Override
						public void onSuccess(Void result) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Login));
						}
						
						@Override
						public void onFailure(Throwable caught) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error,
									"You cant be deleted. Contact us for more info."));
							
						}
					});
				}
				
				@Override
				public void onFailure(Throwable caught) {
					eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error,
							"Impossible to load user in configuration"));
				}
			});
		}
	};
	
	ClickHandler ButtonUpdateUser = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			
			if(!view.getNameText().isEmpty()){
				
//				usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
//				
//					@Override
//					public void onSuccess(UserDTO result) {
//						
//						//here the name is updated
//						if(!view.getNameText().equals(result.getName())){
//							usersManager.setNameUser(view.getNameText(), new AsyncCallback<Void>() {
//						
//								@Override
//								public void onSuccess(Void result) {
//									usersManager.setNameUser(view.getNameText(), new AsyncCallback<Void>() {
//
//										@Override
//										public void onFailure(Throwable caught) {
//											// TODO Auto-generated method stub
//											
//										}
//
//										@Override
//										public void onSuccess(Void result) {
//											// TODO Auto-generated method stub
//											
//										}
//									});
//								}
//						
//								@Override
//								public void onFailure(Throwable caught) {
//									eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error,
//											"Impossible to load user in configuration"));
//
//								}
//							});
//
//						}
//						//here the password is updated
//						if(!view.getPass1Text().isEmpty() && !view.getPass2Text().isEmpty()){
//							usersManager.setPassUser(view.getPass1Text(), view.getPass2Text(), new AsyncCallback<Void>() {
//								
//								@Override
//								public void onSuccess(Void result) {
//									
//							
//								}
//						
//								@Override
//								public void onFailure(Throwable caught) {
//									eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error,
//											"Impossible to update user information in configuration"));
//									
//								}
//							});
//						}
//
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			
//			
				
				//here the name is updated
				if(!view.getNameText().isEmpty()){
					usersManager.setNameUser(view.getNameText(), new AsyncCallback<Void>() {
				
						@Override
						public void onSuccess(Void result) {
							usersManager.setNameUser(view.getNameText(), new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Void result) {
									// TODO Auto-generated method stub
									
								}
							});
						}
				
						@Override
						public void onFailure(Throwable caught) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error,
									"Impossible to load user in configuration"));

						}
					});

				}
				//here the password is updated
				if(!view.getPass1Text().isEmpty() && !view.getPass2Text().isEmpty()){
					usersManager.setPassUser(view.getPass1Text(), view.getPass2Text(), new AsyncCallback<Void>() {
						
						@Override
						public void onSuccess(Void result) {
							
					
						}
				
						@Override
						public void onFailure(Throwable caught) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error,
									"Impossible to update user information in configuration"));
							
						}
					});
				}
			}
		}
		
	};

	Command optionAllViewOpinionCommand = new Command() {
		public void execute() {
			boolean showAll;
			if(optionViewAllOpinion.getText().equals(DISABLE_OPTION)){
				optionViewAllOpinion.setText(ENABLE_OPTION);
				showAll = false;
			}else{
				optionViewAllOpinion.setText(DISABLE_OPTION);
				showAll = true;
			}
		}
	};

}