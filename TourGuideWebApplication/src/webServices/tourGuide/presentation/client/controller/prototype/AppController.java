package webServices.tourGuide.presentation.client.controller.prototype;

import webServices.tourGuide.presentation.client.presenters.prototype.IPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * AppControlles de una aplicacion que contiene una pagina principal y dentro de la misma
 * existe un container en el que se pintaran las demas pantallas.
 * @author bogulin
 *
 */
public abstract class AppController implements IAppController{
	
	private HandlerManager eventBus;
	// container principal para toda la aplicacion
	private HasWidgets     containerPrincipal;
	// el container que se repintara con cada pantalla, este estara interno en el anterior.
	private HasWidgets     container;
	
	// si es una web con una pantalla principal y dentro de este frame
	private IPresenter	   principal;
	private IPresenter	   presenterActive;
	
	//item principal que se colocara en el history
	private String		   mainItem = "main";
	
	/**
	 * Metodo de presenter se invocara para dar comienzo a la ejecucion del appController.
	 */
	@Override
	public void go(final HasWidgets container, final HandlerManager eventBus){
		this.eventBus  			= eventBus;
		this.containerPrincipal = container;
		
		// Dejaremos que nuestro hijo carga todo lo que necesite...
		loadController();
		
		if ("".equals(History.getToken())) {
			History.newItem(mainItem);			
		} else {
			History.fireCurrentHistoryState();
		}
		
		Window.addWindowClosingHandler(new ClosingHandler() {
			
			@Override
			public void onWindowClosing(ClosingEvent event) {
				
				// If we want to ask a confirmation to the user...
				//event.setMessage("Are you sure?");
				
				dispose();
			}
		});
	}
	
	/**
	 * Metodo virtual puro para dejar cargas iniciales a mis herederos.
	 */
	public abstract void loadController();

	@Override
	public void dispose(){
		
		disposeController();
		
		if(getPrincipal() != null){
			getPrincipal().dispose();
		}
		
		if(getPresenterActive() != null){
			getPresenterActive().dispose();
		}
	}
	
	/**
	 * Metodo virtual puro para cerrar cordialmente a mis herederos.
	 */
	public abstract void disposeController();
	

	public HandlerManager getEventBus() {
		return eventBus;
	}

	public void setEventBus(HandlerManager eventBus) {
		this.eventBus = eventBus;
	}
	
	public HasWidgets getContainerPrincipal() {
		return containerPrincipal;
	}

	public void setContainerPrincipal(HasWidgets containerPrincipal) {
		this.containerPrincipal = containerPrincipal;
	}
	
	public HasWidgets getContainer() {
		return container;
	}

	public void setContainer(HasWidgets container) {
		this.container = container;
	}

	public IPresenter getPrincipal() {
		return principal;
	}

	public void setPrincipal(IPresenter principal, Widget view) {
		setPrincipal(principal, view, null);
	}
	
	public void setPrincipal(IPresenter principal, Widget view, HasWidgets container) {
		if(this.principal != null){
			this.principal.dispose();
		}
		
		if(principal == null || view == null){
			throw new IllegalArgumentException("presenter or view principal null");
		}
		
		this.principal = principal;
		
		setContainer(container);
		
		this.principal.go(getContainerPrincipal(), view);
	}

	public IPresenter getPresenterActive() {
		return presenterActive;
	}

	public void setPresenterActive(IPresenter presenterActive, Widget view) {
		if(this.presenterActive != null){
			this.presenterActive.dispose();
		}
		
		if(getContainer() == null){
			throw new IllegalStateException("Container principal not found.");
		}
			
		this.presenterActive = presenterActive;
		
		this.presenterActive.go(getContainer(), view);
	}

	public String getMainItem() {
		return mainItem;
	}

	public void setMainItem(String mainItem) {
		if(mainItem == null){
			throw new IllegalArgumentException("mainItem null");
		}
		
		// no se establecio nunca...
		if(this.mainItem.equals("main")){
			this.mainItem = mainItem;
		}
	}
}
