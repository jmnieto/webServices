package webServices.tourGuide.presentation.client.presenters;

import webServices.tourGuide.domainLogic.services.interfaces.user.UsersServiceAsync;
import webServices.tourGuide.presentation.client.events.NavigationEvent;
import webServices.tourGuide.presentation.client.presenters.prototype.Presenter;
import webServices.tourGuide.presentation.dataTransferObjects.ResponseLoginDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;


public class LoginPresenter extends Presenter{
	
	public interface Display{
		public Widget 		  asWidget();
		
		//Textbox
		public void				focusUsername();
		public String			getUsername();
		public String			getPassword();
		
		//Button
		public HasClickHandlers getEnter();
		public HasClickHandlers getRegister();
		
		// Error
		public void				setVisibleError(boolean visible);
		public void				setVisibleError(boolean visible, String text);
				
		public void clear();
	}
	
	private HandlerManager 	  eventBus;
	private Display 		  view;
	
	private UsersServiceAsync usersManager;
	
	public LoginPresenter(HandlerManager eventBus, Display view, UsersServiceAsync userManager) {
		this.eventBus 	  = eventBus;
		this.view	  	  = view;
		this.usersManager = userManager;
	}

	@Override
	public void init() {
		addHandlerRegistration(view.getEnter().addClickHandler(enter));
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
	
//////////////////////////////Enter button///////////////////////////////
	ClickHandler enter = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			
			view.setVisibleError(false);
			
			if(view.getUsername().isEmpty() || view.getPassword().isEmpty()){
				view.setVisibleError(true);
				view.focusUsername();
			}else{
				eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Principal));
//				usersManager.loginUser(view.getUsername(), view.getPassword(), new AsyncCallback<ResponseLoginDTO>() {
//					
//					@Override
//					public void onSuccess(ResponseLoginDTO result) {
//						if(result.isLoginSuccessful()){
//							eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Principal));
//						}else{
//							view.setVisibleError(true, result.getMessage());
//							view.focusUsername();
//						}
//					}
//					
//					@Override
//					public void onFailure(Throwable caught) {
//						view.setVisibleError(true, caught.getMessage());
//					}
//				});
			}
		}
	};
	
//////////////////////////////Register button///////////////////////////////
ClickHandler register = new ClickHandler() {

@Override
public void onClick(ClickEvent event) {

view.setVisibleError(false);

if(view.getUsername().isEmpty() || view.getPassword().isEmpty()){
view.setVisibleError(true);
view.focusUsername();
}else{
eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Principal));
//usersManager.loginUser(view.getUsername(), view.getPassword(), new AsyncCallback<ResponseLoginDTO>() {
//
//@Override
//public void onSuccess(ResponseLoginDTO result) {
//if(result.isLoginSuccessful()){
//	eventBus.fireEvent(new NavigationEvent(NavigationEvent.Navigation.Principal));
//}else{
//	view.setVisibleError(true, result.getMessage());
//	view.focusUsername();
//}
//}
//
//@Override
//public void onFailure(Throwable caught) {
//view.setVisibleError(true, caught.getMessage());
//}
//});
}
}
};
}