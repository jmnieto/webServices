package webServices.tourGuide.presentation.client.views.principal;

import webServices.tourGuide.presentation.client.presenters.PrincipalPresenter;

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
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class PrincipalView extends Composite implements PrincipalPresenter.Display{
	private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "DownloadLog";
	
	private static PrincipalViewUiBinder uiBinder = GWT.create(PrincipalViewUiBinder.class);
	@UiField FlowPanel MenuBar;
	@UiField FlowPanel CentralPanel;
	@UiField FormPanel formDownload;
	@UiField FlowPanel ListPanel;
	@UiField HorizontalPanel MenuContainer;
	@UiField HorizontalPanel Picture;
	@UiField ToggleButton ButtonMap;
	@UiField ToggleButton ButtonPlaces;
	@UiField ToggleButton ButtonConfiguration;
	@UiField ToggleButton ButtonLogOut;
	

	// dominio About;
	private ToggleButton DomainAbout;
	private MenuBar 	 userProfile;
	
	// Contedra todos los botones del dominio.
	private List<ToggleButton> 	domains;
	private List<ToggleButton> 	functions;
	
	interface PrincipalViewUiBinder extends UiBinder<Widget, PrincipalView> {
	}

	public PrincipalView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		downloadForm();
	}
	
	private void downloadForm() {
		// Propiedades de envio del Form.
		formDownload.setAction(UPLOAD_ACTION_URL);
		formDownload.setEncoding(FormPanel.ENCODING_MULTIPART);
		formDownload.setMethod(FormPanel.METHOD_POST);
	}
	
	@Override
	public Widget asWidget(){
		return this;
	}

	
	@Override
	public void addProfile(MenuBar userProfile) {
		this.userProfile = userProfile;
		MenuBar.insert(userProfile, MenuBar.getWidgetCount()-1);
	}
	
	@Override
	public HasClickHandlers getDomainAbout() {
		return DomainAbout;
	}
	
	@Override
	public List<ToggleButton> getItems() {
		return domains;
	}

	@Override
	public Panel getCentralPanel() {
		return CentralPanel;
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
		for(Widget w : domains){
			MenuBar.remove(w);
		}
		
		
		// eliminamos el profile si no es nulo
		if(userProfile != null){
			MenuBar.remove(userProfile);
		}

		// eliminamos la funcion de uploadConfig
	}

	@Override
	public FormPanel downloadPanel() {
		return formDownload;
	}

	@Override
	public void addItem(ToggleButton item) {
		MenuBar.insert(item, MenuBar.getWidgetCount()-1);
		domains.add(item);
		
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
	public Panel getPanelMap() {
		// TODO Auto-generated method stub
		return CentralPanel;
	}

	@Override
	public Panel getPanelPlaces() {
		// TODO Auto-generated method stub
		return ListPanel;
	}

	@Override
	public HasClickHandlers getMapButton() {
		// TODO Auto-generated method stub
		return ButtonMap;
	}

	@Override
	public HasClickHandlers getMyPlacesButton() {
		// TODO Auto-generated method stub
		return ButtonPlaces;
	}

	@Override
	public HasClickHandlers getConfigurationButton() {
		// TODO Auto-generated method stub
		return ButtonConfiguration;
	}

	@Override
	public HasClickHandlers getLogOutButton() {
		// TODO Auto-generated method stub
		return ButtonLogOut;
	}


	


}
