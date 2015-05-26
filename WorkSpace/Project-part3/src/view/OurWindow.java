package view;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public abstract class OurWindow extends Observable implements Runnable {
	
	Display display;
	Shell shell;
	
	public OurWindow(String title, int width, int height) {
		display=new Display();
		shell=new Shell(display);
		shell.setText(title);
		shell.setSize(width,height);
	}
	
	abstract void initWidgets();
	
	public void Run(){
		initWidgets();
		shell.open();
		// main event loop
		 while(!shell.isDisposed()){ // while window isn't closed

		    // 1. read events, put then in a queue.
		    // 2. dispatch the assigned listener
		    if(!display.readAndDispatch()){ 	// if the queue is empty
		       display.sleep(); 			// sleep until an event occurs 
		    }

		 } // shell is disposed

		 display.dispose(); // dispose OS components
		
		
	}
	

}
