package webServices.tourGuide.presentation.client.views.error;


import webServices.tourGuide.presentation.client.presenters.ErrorPresenter;

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
//MAPS


public class ErrorView extends Composite implements ErrorPresenter.Display{


	private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "DownloadLog";
	
	private static MapViewUiBinder uiBinder = GWT.create(MapViewUiBinder.class);
	@UiField HorizontalPanel ErrorPanel;
	@UiField HTMLPanel ContainerPanel;
	

	// dominio About;
	private ToggleButton DomainAbout;
	private MenuBar 	 userProfile;
	
	// Contedra todos los botones del dominio.
	private List<ToggleButton> 	domains;
	private List<ToggleButton> 	functions;
	
	interface MapViewUiBinder extends UiBinder<Widget, ErrorView> {
	}

	public ErrorView() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	
	@Override
	public Widget asWidget(){
		return this;
	}

	
	
	@Override
	public HasClickHandlers getDomainAbout() {
		return DomainAbout;
	}
	
	@Override
	public List<ToggleButton> getItems() {
		return domains;
	}


//	@Override
//	public HasClickHandlers getComparatives() {
//		return Comparatives;
//	}
//
//	@Override
//	public HasClickHandlers getSimpleText() {
//		return SimpleText;
//	}
	
	@Override
	public List<ToggleButton> getFunction() {
		return functions;
	}

	@Override
	public void clear() {
		
		// eliminamos todos los dominios.
//		for(Widget w : domains){
//			MenuBar.remove(w);
//		}
		
		ErrorPanel.clear();
		
		// eliminamos el profile si no es nulo
		if(userProfile != null){
			//MenuBar.remove(userProfile);
		}

		// eliminamos la funcion de uploadConfig
	}

	@Override
	public void addUploadConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HasClickHandlers getOpinions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getUploadConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public Panel getPanelError() {
		// TODO Auto-generated method stub
		return ErrorPanel;
	}

	@Override
	public void addItem(ToggleButton item) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addProfile(MenuBar userProfile) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public FormPanel downloadPanel() {
		// TODO Auto-generated method stub
		return null;
	}




}
