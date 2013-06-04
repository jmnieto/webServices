package webServices.tourGuide.presentation.client.presenters.prototype;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public abstract class Presenter implements IPresenter {

	private List<HandlerRegistration> listHandler;
	
	@Override
	public void go(HasWidgets container, Widget widget) {
		listHandler = new ArrayList<HandlerRegistration>();
		
		init();
		
		container.clear();
		container.add(widget);
		
		start();
		
	}

	/**
	 * Metodo util para realizar las tareas de inicializacion de presente, como cargar los manejadores, inicializar variables, etc.
	 */
	public abstract void init();
	
	/**
	 * Metodo util para cosas que se tengan que realizar despues de repintar la pantalla, como poner el foco en un determinado textBox.
	 * No es un metodo virtual puro para no obligar a redefinir, es totalmente opcional...
	 */
	public abstract void start();
	
	@Override
	public void refresh() {}
	
	@Override
	public void addClickHandler(HasClickHandlers element, ClickHandler handler) {
		 listHandler.add(element.addClickHandler(handler));
	}
	
	@Override
	public void addHandlerRegistration(HandlerRegistration handler){
		listHandler.add(handler);
	}
	

	@Override
	public void dispose() {
		for(HandlerRegistration reg : listHandler){
			reg.removeHandler();
		}
		
		// Que nuestro hijo limpie lo que necesite.
		finish();
	}

	/**
	 * Metodo usado para realizar todas las tarea de dispose en el presenter, como el eliminar los manejadores de los eventos para evitar
	 * duplicidad de los mismos.
	 */
	public abstract void finish();
	
	protected IPresenter getPresenter(){
		return this;
	}
}
