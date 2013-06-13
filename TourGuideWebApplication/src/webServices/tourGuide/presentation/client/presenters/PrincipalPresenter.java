package webServices.tourGuide.presentation.client.presenters;

import java.util.List;

import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.presenters.prototype.Presenter;
import webServices.tourGuide.presentation.client.util.Loading;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
//MAPS
//TABLE

public class PrincipalPresenter extends Presenter{
	
	
	public interface Display{
		public Widget 				asWidget();
		
		// Items for the menu, those items will appear into the top bar
		public void 				addItem(ToggleButton item);
		
		// User profile
		public void 				addProfile(MenuBar userProfile);
		
		// We will get every items on the top bar.
		public List<ToggleButton> 	getItems();
		
		// Event de los dominios
		public HasClickHandlers 	getDomainAbout();

		// Evento de click en la barra desplazadora
		public Panel				getCentralPanel();
		
		// Eventos de las funcionalidades.
		public void					addUploadConfig();
		public HasClickHandlers 	getOpinions();
		public HasClickHandlers 	getUploadConfig();
		public List<ToggleButton> 	getFunction();
		
		public FormPanel 			downloadPanel();
		
		public void clear();
		
		public HasClickHandlers getMapButton();
		public HasClickHandlers getMyPlacesButton();
		public HasClickHandlers getConfigurationButton();
		public HasClickHandlers getLogOutButton();
		
		
		//MAP
		public Panel getPanelMap();
		//TABLE PLACES
		public Panel getPanelPlaces();
		public void setLabelWelcome(String name);
	}
	
	private HandlerManager 	eventBus;
	private Display 		view;
	
	private UsersServiceAsync usersManager;

//	Mensajes de Item optionviewAllopinion
	private final String DISABLE_OPTION = "Disable all opinion";
	private final String ENABLE_OPTION  = "Enable all opinion";
	
//	private ResourcesServiceAsync resources;
//	private UsersServiceAsync	  users;
//	private CoreServiceAsync 	  core;
	private String 				  location;
	private final MenuItem		  optionViewAllOpinion;
	
	public PrincipalPresenter(HandlerManager eventBus, Display view
							  //ResourcesServiceAsync resources,
							  //UsersServiceAsync users,
							  //CoreServiceAsync core
							  ) {
		
		this.eventBus  			  = eventBus;
		this.view	   			  = view;
		//this.resources 			  = resources;
		//this.users	   			  = users;
		//this.core				  = core;
		this.optionViewAllOpinion = new MenuItem("", optionAllViewOpinionCommand);
	}
	
	@Override
	public void init() {
		addHandlerRegistration(view.getMapButton().addClickHandler(MapButton));
		addHandlerRegistration(view.getMyPlacesButton().addClickHandler(PlacesButton));
		addHandlerRegistration(view.getConfigurationButton().addClickHandler(ConfigurationButton));
		addHandlerRegistration(view.getLogOutButton().addClickHandler(LogOutButton));
		/* Cargamos los dominios disponibles */
		//loadMenu();
		
		/* Barra desplazadora */
		//addClickHandler(view.getCollapsible(),  collapsible);
		
		/* Funciones del sistema */
		//addClickHandler(view.getOpinions(), 	opinions);
		
		//addDomain("Map");
		//addDomain("Places");
		loadUser();
		eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map));
		
	}

	@Override
	public void start() {
	}
	
	@Override
	public void refresh() {
		for(ToggleButton button : view.getFunction()){
			String text = button.getText();
			if(text.equals("Opinions Summary")){
				button.setValue(true);
			}else{
				button.setValue(false);
			}
		}
	}

	@Override
	public void finish() {
		view.clear();
	}

	
	
	/**************************MENU*****************************/
	
	
public void loadUser(){
	usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
		
		@Override
		public void onSuccess(UserDTO result) {
			view.setLabelWelcome(result.getName());
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});
}
//////////////////////////////Map button///////////////////////////////
ClickHandler MapButton = new ClickHandler() {

	@Override
	public void onClick(ClickEvent event) {
		eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map));
	}
};

//////////////////////////////Place button///////////////////////////////
ClickHandler PlacesButton = new ClickHandler() {

	@Override
	public void onClick(ClickEvent event) {
		eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.MyPlaces));
	}
};

//////////////////////////////Config button///////////////////////////////
ClickHandler ConfigurationButton = new ClickHandler() {

	@Override
	public void onClick(ClickEvent event) {
			eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Configuration));
	}
};

//////////////////////////////Config button///////////////////////////////
ClickHandler LogOutButton = new ClickHandler() {

@Override
public void onClick(ClickEvent event) {
	
	usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
		
		@Override
		public void onSuccess(UserDTO result) {
			usersManager.logoutUser(new AsyncCallback<Void>() {
				
				@Override
				public void onSuccess(Void result) {
					eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Login));
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});
//
}
};
	
	/************************ Dominios *************************/
	

private void refreshView() {
	
	Loading.getInstance().hideDialog(getPresenter());
	
	for(ToggleButton button : view.getFunction()){
		if(button.getValue()){
			NavigationEvent event;
			String text = button.getText(); 

			if(text.equals("Map")){
				event = new NavigationEvent(NavigationEvent.Navigation.Map);
			}else if(text.equals("My Places")){
				event = new NavigationEvent(NavigationEvent.Navigation.MyPlaces);
			}else if(text.equals("Configuration")){
				event = new NavigationEvent(NavigationEvent.Navigation.Configuration);
			}else {
				event = new NavigationEvent(NavigationEvent.Navigation.Error);
			}
		
			eventBus.fireEvent(event);
			break;
		}
	}
	
	// cargamos la taxonomia
	//loadTaxonomy();
}

	
//	private void loadDomain() {
//		Loading.getInstance().showDialog("Loading available domains.", getPresenter());
//		
//		resources.getDomains(new AsyncCallback<List<String>>() {
//			
//			@Override
//			public void onSuccess(List<String> result) {
//				
//				if(result.size() == 0){
//					// TODO pantalla de error mostrando que no existe ningun dominio.
//					Loading.getInstance().showDialog("Not Found Domain.", getPresenter());
//				}else{
//					
//					
//					for(String domain : result){
//						addDomain(Character.toUpperCase(domain.charAt(0)) + domain.substring(1, domain.length()));
//					}
//					
//					// cargamos el boton del perfil de usuario.
//					loadUserProfile();
//				}
//			}
//			
//			
//
//			@Override
//			public void onFailure(Throwable caught) {
//				//TODO pantalla de error.
//				Loading.getInstance().showDialog("OnFailure."+ caught.getMessage(), getPresenter());
//			}
//		});
//	}
	
	/**
	 * Crea un boton representando el dominio que se introduce como parametro y le asigna y manejador de evento.
	 * @param domain
	 */
	private void addDomain(String domain) {

		//creamos el nuevo button
		ToggleButton button = new ToggleButton(domain);
		
		//le asignamos el estilo adecuado
		button.setStyleName("MenuBar-Principal-Item");
		
		//creamos un handle para el nuevo dominio
		addClickHandler(button, new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(processButton(event, view.getItems())){
					
					ToggleButton button = (ToggleButton)event.getSource();
					
					// Guardamos el dominio actual
					location = button.getText().toLowerCase();
					
					refreshView();
				}
			}
		});
		
		// add domain a la vista
		view.addItem(button);
	}

	/**
	 * Crea el perfil del usuario conectado, cargando los item necesarios acordes con sus privilegios.
	 */
//	private void loadUserProfile() {
//		Loading.getInstance().showDialog("Loading user profile.", getPresenter());
//		
//		users.getUserConnected(new AsyncCallback<UserDTO>() {
//			
//			@Override
//			public void onSuccess(UserDTO result) {
//							
//				if(result == null){
//					Loading.getInstance().showDialog("Not found connected user, please relogin.", getPresenter(), Priority.HIGH);
//					timer.schedule(5000);
//				}else{
//				
//					// Creamos el menu con el perfil del usuario
//					createMenuBarProfile(result);
//					
//					// Comprobamos si puede subir los ficheros de configuracion
//					loadUploadConfigFuntion(result);
//					
//					// Establecemos el dominio activo
//					setDomainActive();
//	
//					// Refrescamos la pantalla con la funcion que este senyalada. 
//					refreshView();
//					
//					Loading.getInstance().hideDialog(getPresenter());
//				}
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Loading.getInstance().showDialog("Not found connected user.", getPresenter(), Priority.HIGH);
//				timer.schedule(5000);
//			}
//		});
//		
//	}
	
	/**
	 * Creara el MenuBar y lo insertara en la vista. Recibe un userDTO para comprobar los campos que inserta en el menu.
	 * @param result
	 */
//	private void createMenuBarProfile(UserDTO result) {
//		// MenuBar que contendra los item del perfil
//		MenuBar items = new MenuBar(true);
//		//Guardar el item para no duplicar los eventos.
//		if(result.isAdvancedFeatures()){
//			items.addItem("System Reboot", systemReboot);
//		}
//		
//		//Guardar el item para no duplicar los eventos.
//		if(result.isAdvancedFeatures()){
//			items.addItem("Download Log", downloadLog);
//			addHandlerRegistration(view.downloadPanel().addSubmitHandler(onSubmit));
//			addHandlerRegistration(view.downloadPanel().addSubmitCompleteHandler(onSubmitComplete));
//		}
//		items.addSeparator();
//		
//		//Anyadimos el profile del usuariop
//		items.addItem("User Profile", userProfile);
//		
//		//Guardar el item para no duplicar los eventos.
//		if(result.isGestionUser()){
//			items.addItem("User Management", userManagement);
//		}
//		items.addSeparator();
//		if(result.isOpinionView()){
//			optionViewAllOpinion.setText(DISABLE_OPTION);
//		}else{
//			optionViewAllOpinion.setText(ENABLE_OPTION);
//		}
//		
//		items.addItem(optionViewAllOpinion);
//		items.addSeparator();
//		items.addItem("Logout", logout);
//		
//		// MenuBar que contendra los items
//		MenuBar userMenu = new MenuBar();
//		// activamos las propiedades de dinamismo del menu bar.
//		userMenu.setAnimationEnabled(true);
//		userMenu.setAutoOpen(true);
//		userMenu.setFocusOnHoverEnabled(true);
//		// establecemos el estilo al menu
//		userMenu.setStylePrimaryName("MenuBar-Principal-Profile");
//		 
//		// Anyadimos el unico item que contendra.
//		userMenu.addItem(new MenuItem(result.getName(),items));
//		
//		view.addProfile(userMenu);
//	}
	
	/**
	 * Dado el usuario que ha realizado la conexion, se comprueba si tiene privilegios para subir los ficheros de confiruacion
	 * de los pipeline
	 * @param result
	 */
//	private void loadUploadConfigFuntion(UserDTO result) {
//		if(result.isAdvancedFeatures()){
//			view.addUploadConfig();
//			addClickHandler(view.getUploadConfig(), uploadConfig);
//		}
//	}
	
	/**
	 * Se activara el primer dominio existente en la barra de dominios.
	 */
//	private void setDomainActive() {
//		// configuramos el primero por defecto.
//		ToggleButton button = view.getItems().get(0);
//		
//		button.setValue(true);
//		
//		domainActive = button.getText().toLowerCase();
//	}
	
	
	/**
	 * Timer encargado de mostrar mensaje de error y navegar hasta la pantalla de login.
	 */
//	Timer timer = new Timer() {
//		
//		@Override
//		public void run() {
//			eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Login));	
//			Loading.getInstance().hideDialog(getPresenter());
//		}
//	};
//	
//	Command userProfile = new Command() {
//		public void execute() {
//			eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.UserProfile,domainActive));
//		}
//	};
//	
//	Command systemReboot = new Command() {
//		public void execute() {
//			core.systemReboot(new AsyncCallback<Void>() {
//				
//				@Override
//				public void onSuccess(Void result) {
//						logout.execute();			
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					Loading.getInstance().showDialog("Error in process system reboot", getPresenter());
//					new Timer() {
//						
//						@Override
//						public void run() {
//							Loading.getInstance().hideDialog(getPresenter());
//						}
//					}.schedule(3000);
//				}
//			});
//		}
//	};
//	
//	/**
//	 * Controlador para descargar el fichero de log
//	 */
//	Command downloadLog = new Command() {
//		public void execute() {
//			view.downloadPanel().submit();
//		}
//	};
//	
//	SubmitHandler onSubmit = new FormPanel.SubmitHandler() {
//		public void onSubmit(SubmitEvent event) {
//			Loading.getInstance().showDialog("Downloading log file to server...", getPresenter());
//		}
//	};
//	
//	SubmitCompleteHandler onSubmitComplete = new FormPanel.SubmitCompleteHandler() {
//	      public void onSubmitComplete(SubmitCompleteEvent event) {
//	    	  checkResponse(event.getResults());
//	    	  new Timer() {
//					
//					@Override
//					public void run() {
//						Loading.getInstance().hideDialog(getPresenter());
//					}
//				}.schedule(3000);
//	      }
//	};
//	
//	private boolean checkResponse(String response){
//
//		boolean result = true;
//		
////		"<h2>HTTP ERROR: 500</h2><pre>Please use file format Zip</pre>"
//		if(response.contains("HTTP ERROR")){
//			String error = response.substring(response.indexOf("<pre>") + 5 , response.indexOf("</pre>")).trim();
//			Loading.getInstance().showDialog(error, getPresenter());
//			result = false;
//		}
//		
//		return result;
//	}
//	
//	/**
//	 * Controlador para navegar a la pantalla de gestion de usuarios
//	 */
//	Command userManagement = new Command() {
//		public void execute() {
//			eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.UserManagement,domainActive));
//		}
//	};
//	
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
//	
//	/**
//	 * Comando para desconectar al usuario.
//	 */
//	Command logout = new Command() {
//		public void execute() {
//			Loading.getInstance().showDialog("Disconnecting user.", getPresenter());
//			
//			users.logoutUser(new AsyncCallback<Void>() {
//				
//				@Override
//				public void onSuccess(Void result) {
//					timer.run();
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					timer.run();
//				}
//			});
//		}
//	};
//	
//	
//	    
	
//	ClickHandler domainAbout = new ClickHandler() {
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			if(processButton(event, view.getItems())){
//				//TODO colocar el enlace de about...
//				eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.About));
//			}
//		}		
//	};
//	
//	/************************ Taxonomia *************************/
//	private void loadTaxonomy() {
//		
//		resources.getTaxonomy(domainActive, new AsyncCallback<TaxonomyDTO>() {
//			
//			@Override
//			public void onSuccess(TaxonomyDTO result) {
//				OpinionExtractPresenter.setTaxonomy(result);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				//TODO pantalla de error
//			}
//		});
//	}
//	
	/**
	 * Procesa el estado del boton que genera el evento.
	 * @param event
	 * @return cierto si se debe atender al evento.
	 */
	private boolean processButton(ClickEvent event, List<ToggleButton> domain){
		boolean result = false;
		
		ToggleButton button = (ToggleButton)event.getSource();
		//Si el boton esta desactivado quiere decir que esta activado y se pulso sobre el por 
		// lo que no se tratara el evento.
		if(button.getValue()){
			deselectDomain(button, domain);
			result = true;
		}else{
			button.setValue(true);
		}
		
		return result;
	}
//	
//	
//	/**
//	 * Dado un boton del dominio pulsado se desactivaran todos los demas.
//	 */
	private void deselectDomain (ToggleButton domainSelected, List<ToggleButton> domain){
		
		for(ToggleButton button : domain){
			if(!button.equals(domainSelected)){
				button.setValue(false);
			}
		}
	}
//
//	/************************************ Funciones del Menu ****************************************************/
//	ClickHandler opinions = new ClickHandler() {
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			if(processButton(event, view.getFunction())){
//				eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.OpinionsIndex, domainActive.toLowerCase()));
//			}			
//		}
//	};
//	
//	ClickHandler functionComparatives = new ClickHandler() {
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			if(processButton(event, view.getFunction())){
//				eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Comparatives, domainActive.toLowerCase()));
//			}			
//		}
//	};
//	
//	ClickHandler functionSimpleText = new ClickHandler() {
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			if(processButton(event, view.getFunction())){
//				eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.SimpleText, domainActive.toLowerCase()));
//			}			
//		}
//	};
//	
//	ClickHandler uploadConfig = new ClickHandler() {
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			if(processButton(event, view.getFunction())){
//				eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.UploadConfig, domainActive.toLowerCase()));
//			}			
//		}
//	};
//	
//	/************************************ Barra desplazadora ****************************************************/
//	ClickHandler collapsible = new ClickHandler() {
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			Button collapsible = (Button)event.getSource();
//			if(collapsible.getStyleName().equals("BarraDesplazadora")){
//				collapsible.setStyleName("BarraDesplazadora-mostrar");
//				view.getMenuPanel().setStyleName("hidePanel");
//				view.getCentralPanel().setStyleName("Contenido-expandido");
//			}else{
//				collapsible.setStyleName("BarraDesplazadora");
//				view.getMenuPanel().setStyleName("ContenedorPanelMenu");
//				view.getCentralPanel().setStyleName("Contenido");
//			}
//		}
//	};
}