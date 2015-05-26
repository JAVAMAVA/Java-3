package view;


import java.util.HashMap;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import presenter.Presenter;
import presenter.Presenter.Command;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;


public class MazeWindow extends OurWindow implements View{
	
	Presenter c;
	
	
	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2,false)); //just started, needs changing
		
		Button startGame=new Button(shell, SWT.PUSH);
		Button exitGame=new Button(shell, SWT.PUSH);
		
		
	}
	
	 public void keyReleased(KeyEvent e){ //up down left and right movement, not sure if the method should be placed here
		 if (e.keyCode == SWT.ARROW_UP){
			 //move up
		 }
		 if (e.keyCode == SWT.ARROW_DOWN){
			 //move down
		 }
		 if (e.keyCode == SWT.ARROW_LEFT){
			 //move left
		 }
		 if (e.keyCode == SWT.ARROW_RIGHT){
			 //move right
		 }
			 
			 
			 
			 
	 }
	

	public MazeWindow(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Command getUserCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayMaze(Maze m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySolution(Solution s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySuccess(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCommands(HashMap<String, Command> comm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyArg(Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastCommand(Command comm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addobserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	

}
