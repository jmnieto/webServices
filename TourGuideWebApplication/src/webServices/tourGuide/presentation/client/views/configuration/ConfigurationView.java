package webServices.tourGuide.presentation.client.views.configuration;


import webServices.tourGuide.presentation.client.presenters.ConfigurationPresenter;

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
import com.google.gwt.user.client.ui.Label;
//MAPS


public class ConfigurationView extends Composite implements ConfigurationPresenter.Display{

	
	private static ConfigurationViewUiBinder uiBinder = GWT.create(ConfigurationViewUiBinder.class);
	@UiField HTMLPanel ContainerPanel;
	@UiField TextBox TextBoxUserName;
	@UiField TextBox TextBoxPass1;
	@UiField TextBox TextBoxPass2;
	@UiField ToggleButton ButtonUpdate;
	@UiField ToggleButton ButtonDeleteUser;
	@UiField FlowPanel Container;
	@UiField Label LabelError;
	

	
	interface ConfigurationViewUiBinder extends UiBinder<Widget, ConfigurationView> {
	}

	public ConfigurationView() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	
	@Override
	public Widget asWidget(){
		return this;
	}


	@Override
	public void clear() {
		
		Container.clear();
		
	}


	@Override
	public String getNameText() {
		
		return TextBoxUserName.getValue();
	}


	@Override
	public String getPass1Text() {
		// TODO Auto-generated method stub
		return TextBoxPass1.getValue();
	}


	@Override
	public String getPass2Text() {
		// TODO Auto-generated method stub
		return TextBoxPass2.getValue();
	}


	@Override
	public void setNameText(String Name) {
		TextBoxUserName.setText(Name);
	}


	@Override
	public void setVisibleError(boolean visible) {
		setVisibleError(visible, "Repit the password again");
		
	}


	@Override
	public void setVisibleError(boolean visible, String text) {
		LabelError.setText(text);
		LabelError.setVisible(visible);		
	}


	@Override
	public HasClickHandlers getButtonDeleteUser() {
		return ButtonDeleteUser;
	}


	@Override
	public HasClickHandlers getButtonUpdateUser() {
		return ButtonUpdate;
	}







}
