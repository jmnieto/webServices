package webServices.tourGuide.presentation.client.presenters.prototype;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public interface IPresenter {
  public void go(final HasWidgets container, final Widget display);
  
  //Notificacion de refresco.
  public void refresh();
//  public void refresh(IPresenter source);
  
  public void addClickHandler(HasClickHandlers element, ClickHandler handler );
  
  public void addHandlerRegistration(HandlerRegistration handler);
  
  public void dispose();
}
