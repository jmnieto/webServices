package webServices.tourGuide.presentation.client.presenters;

import java.util.ArrayList;
import java.util.List;

import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.presenters.prototype.Presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Icon;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
//MAPS
//TABLE

public class PrincipalPresenter extends Presenter{
	
	//Class to store all the points info.
	public class InterestPoint{
		private LatLng _point;
		private String _name;
		private String _info;
		
		public InterestPoint(LatLng point, String name, String info){
			this._point = point;
			this._info = info;
			this._name = name;
		}
		
		public LatLng getPoint(){
			return this._point;
		}
		public String getName(){
			return this._name;
		}
		public String getInfo(){
			return this._info;
		}
	}
	
	
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
		
		
		//MAP
		public Panel getPanelMap();
		//TABLE PLACES
		public Panel getPanelPlaces();
	}
	
	private HandlerManager 	eventBus;
	private Display 		view;
	
	//MAPS VARIABLES
	private MapWidget       map;
	private LatLng 			initialLocate;
	private Icon			baseIcon;
	List<LatLng>			interestPoints; //List of places to mark
	List<String>			interestInfo; //List of info from places to mark
	List<InterestPoint>     intPoints; //List of InterestPoints.
	
	//TABLE VARIABLES
	private String placeName;
	
//	Mensajes de Item optionviewAllopinion
	private final String DISABLE_OPTION = "Disable all opinion";
	private final String ENABLE_OPTION  = "Enable all opinion";
	
//	private ResourcesServiceAsync resources;
//	private UsersServiceAsync	  users;
//	private CoreServiceAsync 	  core;
	private String 				  domainActive;
	private final MenuItem		  optionViewAllOpinion;
	
	public PrincipalPresenter(HandlerManager eventBus, Display view
							  //ResourcesServiceAsync resources,
							  //UsersServiceAsync users,
							  //CoreServiceAsync core
							  ) {
		
		this.eventBus  			  = eventBus;
		this.view	   			  = view;
		this.interestPoints		  = new ArrayList<LatLng>();
		this.interestInfo		  = new ArrayList<String>();
		this.intPoints			  = new ArrayList<InterestPoint>();
		//this.resources 			  = resources;
		//this.users	   			  = users;
		//this.core				  = core;
		this.optionViewAllOpinion = new MenuItem("", optionAllViewOpinionCommand);
	}
	
	@Override
	public void init() {
		
		
		//Load Map
		
		
		/*TEST*/
		//interestPoints.add(LatLng.newInstance(37.4419, -122.1419));
		//interestInfo.add("Palo alto lo peta. Asi que ven a verlo.");
		/*InterestPoint pt = new InterestPoint(LatLng.newInstance(37.4419, -122.1419),"Sitio A","Palo alto lo peta. Asi que ven a verlo.");
		intPoints.add(pt);
		InterestPoint pt2 = new InterestPoint(LatLng.newInstance(38.4419, -122.1419),"Sitio B","Sabes que me comia ahora?s.");
		intPoints.add(pt2);*/
		/*TEST END*/
		
		/*MAP*/
		//We should get this initial location from the server.
		/*initialLocate = LatLng.newInstance(37.4419, -122.1419);
		//Load the map with the localization.
		loadMap(initialLocate);
		//Print the markers around you
		//printPlaces(interestPoints, interestInfo);
		printPlaces (intPoints);
		//view the final map
		//view.getPanelMap().add(map);
		/*MAP END*/
		
		/*TABLE*/
	   /* CellTable<InterestPoint> table = new CellTable<InterestPoint>();
	    //table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
	    
	    // Add a text column to show the name.
	    TextColumn<InterestPoint> nameColumn = new TextColumn<InterestPoint>() {
	      @Override
	      public String getValue(InterestPoint object) {
	        return object.getName();
	      }
	    };
	    table.addColumn(nameColumn, "Place Name");
	    
	    // Add a text column to show the name.
	    TextColumn<InterestPoint> infoColumn = new TextColumn<InterestPoint>() {
	      @Override
	      public String getValue(InterestPoint object) {
	        return object.getInfo();
	      }
	    };
	    table.addColumn(infoColumn, "Information");
	    
	    // Add a selection model to handle user selection.
	    final SingleSelectionModel<InterestPoint> selectionModel = new SingleSelectionModel<InterestPoint>();
	    table.setSelectionModel(selectionModel);
	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
	        InterestPoint selected = selectionModel.getSelectedObject();
	        if (selected != null) {
	          Window.alert("You selected: " + selected.getInfo());
	        }
	      }
	    });
	    
	 // Set the total row count. This isn't strictly necessary, but it affects
	    // paging calculations, so its good habit to keep the row count up to date.
	    table.setRowCount(intPoints.size(), true);

	    // Push the data into the widget.
	    table.setRowData(0, intPoints);

	    // Add it to the root panel.
	    view.getPanelMap().add(table);*/
	    
		/*TABLE END*/
	    
	    
		/* Cargamos los dominios disponibles */
		//loadDomain();
		
		/* Barra desplazadora */
		//addClickHandler(view.getCollapsible(),  collapsible);
		
		/* Funciones del sistema */
		//addClickHandler(view.getOpinions(), 	opinions);
		
	}

	@Override
	public void start() {
		eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map));
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
	
	
	/****MAPS ON*****/
	/*private void loadMap(LatLng point) {
	    map = new MapWidget(point, 13);
	    map.setSize("500px", "500px");
	    map.setUIToDefault();

	    // Create a base icon for all of our markers that specifies the
	    // shadow, icon dimensions, etc.
	    baseIcon = Icon.newInstance();
	    baseIcon.setShadowURL("http://www.google.com/mapfiles/shadow50.png");
	    baseIcon.setIconSize(Size.newInstance(20, 34));
	    baseIcon.setShadowSize(Size.newInstance(37, 34));
	    baseIcon.setIconAnchor(Point.newInstance(9, 34));
	    baseIcon.setInfoWindowAnchor(Point.newInstance(9, 2));
	    // TOOD(sgross): undocumented?
	    // baseIcon.setInfoShadowAnchor(new GPoint(18, 25));
	  }	
	
	private Marker createMarker(LatLng point, final String infoMarker, int index) {
	    // Create a lettered icon for this point using our icon class
	    final char letter = (char) ('A' + index);
	    Icon icon = Icon.newInstance(baseIcon);
	    icon.setImageURL("http://www.google.com/mapfiles/marker" + letter + ".png");
	    MarkerOptions options = MarkerOptions.newInstance();
	    options.setIcon(icon);
	    final Marker marker = new Marker(point, options);

	    marker.addMarkerClickHandler(new MarkerClickHandler() {

	      public void onClick(MarkerClickEvent event) {
	        InfoWindow info = map.getInfoWindow();
	        info.open(event.getSender(), new InfoWindowContent(infoMarker));
	      }

	    });

	    return marker;
	  }
	
	//private void printPlaces(List<LatLng> points, List<String> info){
	private void printPlaces(List<InterestPoint> points){
		map.clearOverlays();
		
		//Add markers to the map at location in points
		for(int i = 0; i < points.size(); i++){
			LatLng point = points.get(i).getPoint();
			String infoMarker = points.get(i).getInfo();
			map.addOverlay(createMarker(point, infoMarker, i));
		}
		
	}*/
	/****MAPS OFF****/
	
	
	/************************ Dominios *************************/
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
//	private void addDomain(String domain) {
//
//		//creamos el nuevo button
//		ToggleButton button = new ToggleButton(domain);
//		
//		//le asignamos el estilo adecuado
//		button.setStyleName("MenuBar-Principal-Item");
//		
//		//creamos un handle para el nuevo dominio
//		addClickHandler(button, new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				if(processButton(event, view.getItems())){
//					
//					ToggleButton button = (ToggleButton)event.getSource();
//					
//					// Guardamos el dominio actual
//					domainActive = button.getText().toLowerCase();
//					
//					refreshView();
//				}
//			}
//		});
//		
//		// add domain a la vista
//		view.addItem(button);
//	}

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
//	private void refreshView() {
//		
//		Loading.getInstance().hideDialog(getPresenter());
//		
//		for(ToggleButton button : view.getFunction()){
//			if(button.getValue()){
//				NavigationEvent event;
//				String text = button.getText(); 
//
//				if(text.equals("Opinions Summary")){
//					event = new NavigationEvent(NavigationEvent.Navigation.OpinionsIndex, domainActive);
//				}else if(text.equals("Comparatives")){
//					event = new NavigationEvent(NavigationEvent.Navigation.Comparatives, domainActive);
//				}else if(text.equals("Simple Text")){
//					event = new NavigationEvent(NavigationEvent.Navigation.SimpleText, domainActive);
//				}else if(text.equals("Upload Config")){
//					event = new NavigationEvent(NavigationEvent.Navigation.UploadConfig, domainActive);
//				}else{
//					//TODO pantalla de error.
//					event = new NavigationEvent(NavigationEvent.Navigation.OpinionsIndex, domainActive);
//				}
//				
//				eventBus.fireEvent(event);
//				break;
//			}
//		}
//		
//		// cargamos la taxonomia
//		loadTaxonomy();
//	}
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
//	/**
//	 * Procesa el estado del boton que genera el evento.
//	 * @param event
//	 * @return cierto si se debe atender al evento.
//	 */
//	private boolean processButton(ClickEvent event, List<ToggleButton> domain){
//		boolean result = false;
//		
//		ToggleButton button = (ToggleButton)event.getSource();
//		//Si el boton esta desactivado quiere decir que esta activado y se pulso sobre el por 
//		// lo que no se tratara el evento.
//		if(button.getValue()){
//			deselectDomain(button, domain);
//			result = true;
//		}else{
//			button.setValue(true);
//		}
//		
//		return result;
//	}
//	
//	
//	/**
//	 * Dado un boton del dominio pulsado se desactivaran todos los demas.
//	 */
//	private void deselectDomain (ToggleButton domainSelected, List<ToggleButton> domain){
//		
//		for(ToggleButton button : domain){
//			if(!button.equals(domainSelected)){
//				button.setValue(false);
//			}
//		}
//	}
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