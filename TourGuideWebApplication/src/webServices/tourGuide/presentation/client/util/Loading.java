package webServices.tourGuide.presentation.client.util;



import webServices.tourGuide.presentation.client.presenters.prototype.IPresenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * La clase Loading simplemente representa a un dialogBox que permite introducir texto
 * y mostrarlo en un dialogo de carga.
 * @author bogulin
 *
 */
public class Loading{

	public static enum Priority{
		LOW,
		NORMAL,
		HIGH
	}
	
	private static Loading instance;
	
	public static Loading getInstance(){
		if(instance == null){
			instance = new Loading();
		}
		
		return instance;
	}
	
	private DialogBox  dialogBox;
	private Label 	   etiquetaDialog;
	private IPresenter callerPresenter;
	private Priority   priorityActive;
	
	private Loading(){
		//DialogBox Modal y no se oculta automaticamente.
		dialogBox = new DialogBox(false, true);
		dialogBox.setText("Loading");
		dialogBox.setAnimationEnabled(true);
		
		VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		panel.setSpacing(3);
		
		etiquetaDialog = new Label();
		
		SimplePanel p = new SimplePanel(etiquetaDialog);
		panel.add(p);
		Image img = new Image("style/images/LoadingProgressBar.gif");
		img.setWidth("70px");
		
		p = new SimplePanel(img);
		panel.add(p);
		panel.setCellHorizontalAlignment(p.asWidget(), HasHorizontalAlignment.ALIGN_CENTER);
		
		dialogBox.add(panel);
	}
	
	public void showDialog(String text, IPresenter caller){
		showDialog(text, caller, Priority.NORMAL);
	}
	
	public void showDialog(String text, IPresenter caller, Priority priority){
		if(dialogBox.isShowing()){
			if(callerPresenter != null && callerPresenter.equals(caller) && priority.ordinal() >= priorityActive.ordinal()){
				etiquetaDialog.setText(text);
				priorityActive = priority;
			}
		}else{
			callerPresenter = caller;
			priorityActive  = priority;
			etiquetaDialog.setText(text);
			dialogBox.center();
		}
	}
	
	public void hideDialog(IPresenter caller){
		if(callerPresenter != null && callerPresenter.equals(caller)){
			dialogBox.hide();
		}
	}
}
