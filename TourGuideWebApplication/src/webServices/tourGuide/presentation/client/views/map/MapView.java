package webServices.tourGuide.presentation.client.views.map;


import webServices.tourGuide.presentation.client.presenters.MapPresenter;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
//MAPS


public class MapView extends Composite implements MapPresenter.Display{

	
	private static MapViewUiBinder uiBinder = GWT.create(MapViewUiBinder.class);
	@UiField HorizontalPanel MapPanel;
	@UiField HorizontalPanel PlacesPanel;
	@UiField HTMLPanel ContainerPanel;
	@UiField TextBox TextBoxSearch;
	@UiField ToggleButton SearchButton;
	@UiField ToggleButton LocalizeButton;
	

	
	interface MapViewUiBinder extends UiBinder<Widget, MapView> {
	}

	public MapView() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	
	@Override
	public Widget asWidget(){
		return this;
	}


	@Override
	public void clear() {
		
		MapPanel.clear();
		PlacesPanel.clear();
		
	}

	
	@Override
	public Panel getPanelMap() {
		// TODO Auto-generated method stub
		return MapPanel;
	}

	@Override
	public Panel getPanelPlaces() {
		// TODO Auto-generated method stub
		return PlacesPanel;
	}


	@Override
	public Panel getPanelContainer() {
		// TODO Auto-generated method stub
		return ContainerPanel;
	}


	@Override
	public HasClickHandlers getSearchButton() {
		// TODO Auto-generated method stub
		return SearchButton;
	}


	@Override
	public String getSearchText() {
		// TODO Auto-generated method stub
		return TextBoxSearch.getValue();
	}


	@Override
	public HasClickHandlers getLocalizeButton() {
		// TODO Auto-generated method stub
		return LocalizeButton;
	}




}
