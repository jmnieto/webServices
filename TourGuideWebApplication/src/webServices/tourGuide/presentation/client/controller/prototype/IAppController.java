package webServices.tourGuide.presentation.client.controller.prototype;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public interface IAppController {
  public void go(final HasWidgets container, final HandlerManager eventBus);
  public void dispose();
}
