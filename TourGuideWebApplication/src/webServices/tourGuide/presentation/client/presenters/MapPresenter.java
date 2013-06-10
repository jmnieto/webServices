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




public class MapPresenter extends Presenter{
	
	
	public interface Display{
		public Widget 				asWidget();
		
		public void clear();
		
		//MAP-TABLE
		public Panel 	getPanelMap();
		public Panel   	getPanelPlaces();
		public Panel   	getPanelContainer();
		public String 	getSearchText();
		
		public HasClickHandlers getSearchButton();
		public HasClickHandlers getLocalizeButton();

	}
	
	private CellTable<LocationDTO> table = new CellTable<LocationDTO>();
	
	private HandlerManager 	eventBus;
	private Display 		view;
	
	private UsersServiceAsync usersManager;
	private LocationServiceAsync locationManager;
	
//	Mensajes de Item optionviewAllopinion
	private final String DISABLE_OPTION = "Disable all opinion";
	private final String ENABLE_OPTION  = "Enable all opinion";
	
	//MAPS VARIABLES
	private MapWidget       map;
	private LocationDTO 	initialLocation;
	private Icon			baseIcon;
	List<LocationDTO>       intPoints; //List of LocationDTOs.
	
	//TABLE VARIABLES

	private final MenuItem		  optionViewAllOpinion;
	
	
	
	public MapPresenter(HandlerManager eventBus, Display view) {
		
		this.eventBus  			  = eventBus;
		
		this.view	   			  = view;
		this.intPoints			  = new ArrayList<LocationDTO>();
		
		this.optionViewAllOpinion = new MenuItem("", optionAllViewOpinionCommand);
	}
	
	public MapPresenter(HandlerManager eventBus, Display view, LocationDTO location){
		this(eventBus, view);
		this.initialLocation	  = location;
	}
	
	@Override
	public void init() {

		addHandlerRegistration(view.getSearchButton().addClickHandler(SearchButton));
		addHandlerRegistration(view.getLocalizeButton().addClickHandler(LocalizeButton));
		
		/*TEST*/
		LocationDTO pt = new LocationDTO("0","47.4419","11.38","Sitio A","www.pelitos.com","lo peta la descripcion");
		intPoints.add(pt);
		
		pt = new LocationDTO("1","47.50","11.37","Sitio B","www.pelitos22.com","nu veah");
		intPoints.add(pt);
		/*TEST END*/
		
		/*MAP*/
		//We should get this initial location from the server.
		
		/*Geolocation*/
		if(initialLocation == null){
			initialLocation = getGeolocation();
		}
		
		/*What do i have around me?*/
		//intPoints = listLocations(initialLocate);
		
		/*Print map*/
		loadMap(initialLocation);
		printPlaces(intPoints,initialLocation);
		view.getPanelMap().add(map);

		/*MAP END*/
		
		/*TABLE*/
	    printTable(intPoints);
	    
	}

	@Override
	public void start() {}
	
	@Override
	public void refresh() {
	}

	@Override
	public void finish() {
		view.clear();
	}
	
	
	ClickHandler SearchButton = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			
			/*LOOK IN GOOGLE*/
			
			
			/*ADD TO OUR DB*/
			usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
				
				@Override
				public void onSuccess(UserDTO result) {
					
					
					locationManager.getLocations(result.getId(), new AsyncCallback<List<LocationDTO>>() {
						
						@Override
						public void onSuccess(List<LocationDTO> result) {
							
							boolean exist = false;
							
							for(int i = 0; i < result.size(); i++){
								if(result.get(i).getName().equals(view.getSearchText()))
									exist = true;
							}
							
							if(!exist){ //ANADIR AQUI LA LOCALIZATION
								locationManager.addLocation(result.get(0).getId(), 
										view.getSearchText(), new AsyncCallback<LocationDTO>() {
									
									@Override
									public void onSuccess(LocationDTO result) {
										eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map,result));
										
									}
									
									@Override
									public void onFailure(Throwable caught) {
										eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
									}
								});
							}
						}					
						@Override
						public void onFailure(Throwable caught) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
							
						}
					});
					
	
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
				}
			});
		}
	};
	
	ClickHandler LocalizeButton = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			LocationDTO currentLocation = new LocationDTO();
			currentLocation = getGeolocation();
			eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map,currentLocation));
		}
		
	};

	
	/******GEOLOCATION*****/
	
	private LocationDTO getGeolocation(){
		
		final LocationDTO geoLoc = new LocationDTO();
		
		if(!Geolocation.isSupported()){
			System.out.println("Oye no lo soporta premoh");
		}
		
	    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
	        public void onUncaughtException(Throwable e) {
	        	eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
	        }
	      });
		
	    final Geolocation geo = Geolocation.getIfSupported();
	    
	       if(geo == null)
	   	   {
	       	   eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
	   	   }else{
	   		   
	   		   geo.getCurrentPosition(new Callback<Position, PositionError>() {
				
				@Override
				public void onSuccess(Position result) {
					Coordinates c = result.getCoordinates();
					geoLoc.setLat(String.valueOf(c.getLatitude()));
					geoLoc.setLng(String.valueOf(c.getLongitude()));
					System.out.print("Geolocate give back a result: "+geoLoc.getLat()+" "+geoLoc.getLng());
			       	eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map,geoLoc));

				}
				
				@Override
				public void onFailure(PositionError reason) {
					System.out.print("Erroraaaro papa: "+reason.getLocalizedMessage());
					eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));					
				}
			});
	   		   
	   	   }

     return geoLoc;
	}
	
	/*******MAPS ON********/
	
	private LocationDTO getPlacesAroundMe(LocationDTO initialLocation){
		
		return null;
	}

	private List<LocationDTO> listLocations(final LocationDTO initial){
		
			final List<LocationDTO> locations = new ArrayList<LocationDTO>();
		
			usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
				
				@Override
				public void onSuccess(UserDTO result) {
					locationManager.getLocations(initial, new AsyncCallback<List<LocationDTO>>() {
						
						@Override
						public void onSuccess(List<LocationDTO> result) {
							for (int i = 0; i < result.size(); i++){
								locations.add(result.get(i));
							}
						}
						
						@Override
						public void onFailure(Throwable caught) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
							
						}
					});
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
					
				}
			});
			
			return locations;
	}
	
	private void loadMap(LocationDTO initial) {
		
		LatLng point = LatLng.newInstance(Double.valueOf(initial.getLat()),Double.valueOf(initial.getLng()));
		
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
		final Marker marker;
		
		if(index != -1){
			final char letter = (char) ('A' + index);
			Icon icon = Icon.newInstance(baseIcon);
			icon.setImageURL("http://www.google.com/mapfiles/marker" + letter + ".png");
			MarkerOptions options = MarkerOptions.newInstance();
			options.setIcon(icon);
			marker = new Marker(point, options);
		}else{
			Icon icon = Icon.newInstance(baseIcon);
			icon.setImageURL("http://www.google.com/mapfiles/marker.png");
			MarkerOptions options = MarkerOptions.newInstance();
			options.setIcon(icon);
			marker = new Marker(point, options);
		}
		
	    marker.addMarkerClickHandler(new MarkerClickHandler() {

	      public void onClick(MarkerClickEvent event) {
	        InfoWindow info = map.getInfoWindow();
	        info.open(event.getSender(), new InfoWindowContent(infoMarker));
	      }

	    });

	    return marker;
	  }
	
	//private void printPlaces(List<LatLng> points, List<String> info){
	private void printPlaces(List<LocationDTO> points, LocationDTO currentLocation){
		map.clearOverlays();
		
		
		//Add markers to the map at location in points
		for(int i = 0; i < points.size(); i++){
			LatLng point = toLatLng(points.get(i).getLat(),points.get(i).getLng());
			String infoMarker = points.get(i).getDescription();
			map.addOverlay(createMarker(point, infoMarker, i));
		}
		LatLng point = toLatLng(currentLocation.getLat(), currentLocation.getLng());
		map.addOverlay(createMarker(point,"This is your current position",-1));
	}
	
	private LatLng toLatLng(String lat, String lng){
		LatLng point = LatLng.newInstance(Double.valueOf(lat), Double.valueOf(lng));
		return point;
		
	}
	/****MAPS OFF****/
	
	/****TABLE ON****/
	public void addButtonToColumn(final String nameToShow, String nameColumn){
		
		ButtonCell buttonCell = new ButtonCell();
	    Column button = new Column<LocationDTO, String>(buttonCell) {
	      @Override
	      public String getValue(LocationDTO object) {
	        // The value to display in the button.
	        return nameToShow;
	      }

	    };
	    
	    button.setFieldUpdater(new FieldUpdater<LocationDTO, String>() {
	    	  public void update(int index, LocationDTO object, String value) {
	    	    // Value is the button value.  Object is the row object.
	    	    //Window.alert("You will be redirected to: " + value);
	    		 if(value.equals("Go to map")){
	    			 eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map,object));
	    		 }else if(value.equals("Link")){
	    			Window.alert("You will be redirected to: " + object.getLink());
	    		 }
	    	  }
	    	});
	    
	    table.addColumn(button, nameColumn);
	    
	}
	
	public void printTable(List<LocationDTO> listOfPlaces){
		
		
	    //table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
	    
	    SimplePager pager;
	    
	    // Create a Pager to control the table.
	    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	    pager.setDisplay(table);
	    
	    
		/*Column 1*/
	    // Add a text column to show the name.
	    TextColumn<LocationDTO> nameColumn = new TextColumn<LocationDTO>() {
	      @Override
	      public String getValue(LocationDTO object) {
	        return object.getName();
	      }
	    };
	    table.addColumn(nameColumn, "Place Name");
	    
	    /*Column 2*/
	    // Add a text column to show the name.
	    TextColumn<LocationDTO> infoColumn = new TextColumn<LocationDTO>() {
	      @Override
	      public String getValue(LocationDTO object) {
	        return object.getName();
	      }
	    };
	    table.addColumn(infoColumn, "Information");
	    
	    addButtonToColumn("Link", "Wikipedia");	    
	    
	    // Add a selection model to handle user selection.
//	    final SingleSelectionModel<LocationDTO> selectionModel = new SingleSelectionModel<LocationDTO>();
//	    table.setSelectionModel(selectionModel);
//	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//	      public void onSelectionChange(SelectionChangeEvent event) {
//	        LocationDTO selected = selectionModel.getSelectedObject();
//	        if (selected != null) {
//	          Window.alert("You should go to: " + selected.getLink());
//	        }
//	      }
//	    });
	    
	 // Set the total row count. This isn't strictly necessary, but it affects
	    // paging calculations, so its good habit to keep the row count up to date.
	    table.setRowCount(listOfPlaces.size(), true);

	    // Push the data into the widget.
	    table.setRowData(0, listOfPlaces);

	    // Add it to the root panel.
	    view.getPanelPlaces().add(table);
	    
	}
	/****TABLE OFF***/

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