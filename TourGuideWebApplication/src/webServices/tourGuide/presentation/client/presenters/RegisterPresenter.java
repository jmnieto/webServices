package webServices.tourGuide.presentation.client.presenters;

import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.presenters.prototype.Presenter;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseDTO;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLoginDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;


public class RegisterPresenter extends Presenter{
	
	public interface Display{
		public Widget 		  asWidget();
		
		//Textbox
		public void				focusUsername();
		public String			getUsername();
		public String			getPassword();
		public String			getPassword2();
		
		//Button
		public HasClickHandlers getOk();
		
		// Error
		public void				setVisibleError(boolean visible);
		public void				setVisibleError(boolean visible, String text);
		
		public HasClickHandlers getRegisterButton();
				
		public void clear();
	}

	
	private HandlerManager 	  eventBus;
	private Display 		  view;
	
	private UsersServiceAsync usersManager;
	
	public RegisterPresenter(HandlerManager eventBus, Display view, UsersServiceAsync userManager) {
		this.eventBus 	  = eventBus;
		this.view	  	  = view;
		this.usersManager = userManager;
	}

	@Override
	public void init() {
		addHandlerRegistration(view.getRegisterButton().addClickHandler(ButtonRegister));
	}


	@Override
	public void start() {
		//colocamos el foco en el nombre de usuario.
		view.focusUsername();
	}
	
	@Override
	public void finish() {
		// limpiamos la vista...
		view.clear();
		
	}
	
//////////////////////////////OK button///////////////////////////////
	//DONE
	ClickHandler ButtonRegister = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			
			view.setVisibleError(false);
			
			if(view.getUsername().isEmpty() || view.getPassword().isEmpty()){
				view.setVisibleError(true);
				view.focusUsername();
			}else{
				usersManager.addUser(view.getUsername(), view.getPassword(), view.getPassword2(), "", new AsyncCallback<ResponseDTO>() {
					
					@Override
					public void onSuccess(ResponseDTO result) {
						//eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Principal));
						usersManager.loginUser(view.getUsername(), view.getPassword(), new AsyncCallback<ResponseLoginDTO>() {
							
							@Override
							public void onSuccess(ResponseLoginDTO result) {
								if(result.isLoginSuccessful()){
									eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Principal));
								}else{
									view.setVisibleError(true, result.getMessage());
									view.focusUsername();
								}
							}
							
							@Override
							public void onFailure(Throwable caught) {
								view.setVisibleError(true, caught.getMessage());
							}
						});
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						view.setVisibleError(true, caught.getMessage());
					}
				});
			}
		}
	};
}