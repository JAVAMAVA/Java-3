package view;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import presenter.Presenter.Command;


public class MyView extends Observable implements View {
	
	HashMap<String, Command> comm=new HashMap<String,Command>();
	public Command lastcommand;
	MyCLI c;
	public MyView() {
		c=new MyCLI();
	}
	@Override
	public void addobserver(Observer observer)
	{
		this.addObserver(observer);
	}
	
	@Override
	public void start()
	{
		setChanged();
		notifyObservers("start");
		String str=c.start();
		if(comm.get(str)!=null)
			lastcommand=comm.get(str);
		else this.notifyArg(str);
		
	}
	@Override
	public void notifyArg(Object arg) {
		setChanged();
		notifyObservers(arg);
		
	}

	@Override
	public void setCommands(HashMap<String, Command> comm) {
		this.comm=comm;
		c.hm=comm;
		
	}

	@Override
	public Command getUserCommand() {
		return this.lastcommand;
	}

	@Override
	public void displayMaze(Maze m) {
		MazeDispleyer MD=new MyMazeDispleyer();
		MD.display(m);
		
	}

	@Override
	public void displaySolution(Solution s) {
		s.printSolution();
		
	}

	@Override
	public void displaySuccess(String str) {
		System.out.println(str);
		
	}

	@Override
	public void setLastCommand(Command comm) {
		this.lastcommand=comm;
		
	}


}
