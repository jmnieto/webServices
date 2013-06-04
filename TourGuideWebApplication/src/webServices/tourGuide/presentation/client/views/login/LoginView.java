package webServices.tourGuide.presentation.client.views.login;

import webServices.tourGuide.presentation.client.presenters.LoginPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite implements LoginPresenter.Display{

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);
	@UiField TextBox TextBoxUserName;
	@UiField PasswordTextBox TextBoxPassword;
	@UiField Button ButtonEnter;
	@UiField Label ErrorText;
	
	private final String defaultErrorText = "The username or password you entered is incorrect.";

	interface LoginViewUiBinder extends
			UiBinder<Widget, LoginView> {
		
	}

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void focusUsername() {
		TextBoxUserName.setFocus(true);
		TextBoxUserName.selectAll();
	}

	@Override
	public String getUsername() {
		return TextBoxUserName.getValue();
	}

	@Override
	public String getPassword() {
		return TextBoxPassword.getValue();
	}

	@Override
	public HasClickHandlers getEnter() {
		return ButtonEnter;
	}

	@Override
	public void setVisibleError(boolean visible) {
		setVisibleError(visible, defaultErrorText);
	}
	
	@Override
	public void setVisibleError(boolean visible, String text) {
		ErrorText.setText(text);
		ErrorText.setVisible(visible);
	}
	
	@Override
	public void clear() {
		TextBoxUserName.setValue("");
		TextBoxPassword.setValue("");
		setVisibleError(false);
	}

	
	
	
	
	
	

}
