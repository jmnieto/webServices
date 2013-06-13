package webServices.tourGuide.presentation.client.presenters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import webServices.tourGuide.domainLogic.services.interfaces.location.LocationServiceAsync;
import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.presenters.prototype.Presenter;
import webServices.tourGuide.presentation.dataTransferObjects.LocationDTO;
import webServices.tourGuide.presentation.dataTransferObjects.UserDTO;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
//MAPS

public class MyPlacesPresenter extends Presenter{
	
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


		
		// Eventos de las funcionalidades.
		public void					addUploadConfig();
		public HasClickHandlers 	getOpinions();
		public HasClickHandlers 	getUploadConfig();
		public List<ToggleButton> 	getFunction();
		
		public FormPanel 			downloadPanel();
		
		public void clear();
		
		public Panel getPanelMyPlaces();
		public HasClickHandlers getDeleteButton();


	}
	
	private HandlerManager 	eventBus;
	private Display 		view;
	
//	Mensajes de Item optionviewAllopinion
	private final String DISABLE_OPTION = "Disable all opinion";
	private final String ENABLE_OPTION  = "Enable all opinion";
	

	
	//TABLE VARIABLES
	private List<LocationDTO> 		listOfPlaces;
	private List<LocationDTO>		locationsToDelete;
	private String 				    placeName;
	
//	private ResourcesServiceAsync resources;
//	private UsersServiceAsync	  users;
//	private CoreServiceAsync 	  core;
	private String 				  domainActive;
	private final MenuItem		  optionViewAllOpinion;
	
	private UsersServiceAsync usersManager;
	private LocationServiceAsync locationManager;
	
	CellTable<LocationDTO> table = new CellTable<LocationDTO>();
	
	public MyPlacesPresenter(HandlerManager eventBus, Display view
							  //ResourcesServiceAsync resources,
							  //UsersServiceAsync users,
							  //CoreServiceAsync core
							  ) {
		
		this.eventBus  			  = eventBus;
		this.view	   			  = view;
		this.listOfPlaces		  = new ArrayList<LocationDTO>();
		this.locationsToDelete	  = new ArrayList<LocationDTO>();
		//this.resources 			  = resources;
		//this.users	   			  = users;
		//this.core				  = core;
		this.optionViewAllOpinion = new MenuItem("", optionAllViewOpinionCommand);
	}
	
	@Override
	public void init() {

		addHandlerRegistration(view.getDeleteButton().addClickHandler(DeleteButton));
		
		/*TEST ON*/
		LocationDTO pt = new LocationDTO("0","37.4419","-122.1419","Sitio A","www.pelitos.com","lo peta la descripcion");
		listOfPlaces.add(pt);
		
		pt = new LocationDTO("1","45.4419","-122.1419","Sitio B","www.pelitos22.com","nu veah");
		listOfPlaces.add(pt);
		/*TEST OFF*/
		
		/*TABLE*/
		//listOfPlaces = listLocation();
		printTable(listOfPlaces);
		/*TABLE END*/

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
	
	public List<LocationDTO> listLocation(){
		
		final List<LocationDTO> listLoc = new ArrayList<LocationDTO>();
		
		usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
			
			@Override
			public void onSuccess(UserDTO result) {
				locationManager.getLocations(result.getId(), new AsyncCallback<List<LocationDTO>>() {
					
					@Override
					public void onSuccess(List<LocationDTO> resultList) {
						for(int i = 0; i < resultList.size(); i++)
							listLoc.add(resultList.get(i));
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
		
		return listLoc;
	}
	
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
	    
		 // Add a selection model so we can select cells.
	    final SelectionModel<LocationDTO> selectionModel = new MultiSelectionModel<LocationDTO>();
	    table.setSelectionModel(selectionModel,
	        DefaultSelectionEventManager.<LocationDTO> createCheckboxManager());
	    
	    // CHECKBOX column. This table will uses a checkbox column for selection.
	    // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
	    // mouse selection.
	    Column<LocationDTO, Boolean> checkColumn = new Column<LocationDTO, Boolean>(
	        new CheckboxCell(true, false)) {
	      @Override
	      public Boolean getValue(LocationDTO object) {
	        // Get the value from the selection model.
	        return selectionModel.isSelected(object);
	      }
	    };
	    
	    table.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
	    table.setColumnWidth(checkColumn, 40, Unit.PX);
	    
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
	        return object.getDescription();
	      }
	    };
	    table.addColumn(infoColumn, "Information");
	    
	    /*Column 3*/
	    // Add a text column to show the name.
	    TextColumn<LocationDTO> linkColumn = new TextColumn<LocationDTO>() {
	      @Override
	      public String getValue(LocationDTO object) {
	        return object.getLink();
	      }
	    };
	    table.addColumn(linkColumn, "Wikipedia link");
	    

	    addButtonToColumn("Link", "Wikipedia");
	    
	    addButtonToColumn("Go to map","");

	    // Add a selection model to handle user selection.
	  /*  final SingleSelectionModel<LocationDTO> selectionModelLink = new SingleSelectionModel<LocationDTO>();
	    table.setSelectionModel(selectionModelLink);
	    selectionModelLink.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
	        LocationDTO selected = selectionModelLink.getSelectedObject();
	        if (selected != null) {
	          Window.alert("You selected: " + selected.getLink());
	        //	eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Map));
	        }
	      }
	    });*/

	      
	    
	 // Set the total row count. This isn't strictly necessary, but it affects
	    // paging calculations, so its good habit to keep the row count up to date.
	    table.setRowCount(listOfPlaces.size(), true);

	    // Push the data into the widget.
	    table.setRowData(0, listOfPlaces);

	    // Add it to the root panel.
	    view.getPanelMyPlaces().add(table);
	    
	}
	
	/*********BUTTONS*************/
	
	ClickHandler DeleteButton = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			/*usersManager.getUserConnected(new AsyncCallback<UserDTO>() {
				
				@Override
				public void onSuccess(UserDTO result) {
					Set<LocationDTO> s = ((MultiSelectionModel<LocationDTO>)(table.getSelectionModel())).getSelectedSet(); 
					java.util.Iterator<LocationDTO> it = s.iterator();
					
					while(it.hasNext()){
						locationsToDelete.add(it.next());
					}
					
					locationManager.deleteLocation(result.getId(), locationsToDelete, new AsyncCallback<Void>() {
						
						@Override
						public void onSuccess(Void result) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.MyPlaces));
						}
						
						@Override
						public void onFailure(Throwable caught) {
							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
						}
					});
				}
				@Override
				public void onFailure(Throwable caught) {
//					Loading.getInstance().showDialog("Not found connected user.", getPresenter(), Priority.HIGH);
//					timer.schedule(5000);
					eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Error));
				}
			});*/
			
			Set<LocationDTO> s = ((MultiSelectionModel<LocationDTO>)(table.getSelectionModel())).getSelectedSet(); 
			System.out.print(s.size());
			java.util.Iterator<LocationDTO> it = s.iterator();
			int i =0;
			LocationDTO aux = new LocationDTO();
			
			while(it.hasNext()){
				aux = it.next();
				//System.out.print(aux.getLink());
				locationsToDelete.add(aux);
				//System.out.print(locationsToDelete.get(i).getLink());
				//i++;
				
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