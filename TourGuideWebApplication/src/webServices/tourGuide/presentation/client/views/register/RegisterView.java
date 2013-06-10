package webServices.tourGuide.presentation.client.views.register;

import webServices.tourGuide.presentation.client.presenters.RegisterPresenter;
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

public class RegisterView extends Composite implements RegisterPresenter.Display{

	private static RegisterUiBinder uiBinder = GWT
			.create(RegisterUiBinder.class);
	@UiField TextBox TextBoxUserName;
	@UiField PasswordTextBox TextBoxPassword;
	@UiField Button ButtonOk;
	@UiField Label ErrorText;
	@UiField PasswordTextBox TextBoxPassword2;
	
	private final String defaultErrorText = "The username or password you entered is incorrect.";

	interface RegisterUiBinder extends
			UiBinder<Widget, RegisterView> {
	}

	public RegisterView() {
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
	public HasClickHandlers getOk() {
		return ButtonOk;
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

	@Override
	public HasClickHandlers getRegisterButton() {
		return ButtonOk;
	}

	@Override
	public String getPassword2() {
		return TextBoxPassword2.getValue();
	}
}
