package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import model.Model;
import view.View;
/**
 * Presenter is the the class that runs every command and control the actions. It has a {@link View} and a {@link Model} that i controls on.
 * The class implements {@link Observer} and that means it gets notifications from the {@link View} and the {@link Model}
 * @author Michael & Amit
 *
 *
 */
public class Presenter implements Observer {
	View v;
	Model m;
	HashMap<String,Command> comm=new HashMap<String, Command>();
	public Presenter(View v,Model m) {
		this.v=v;
		this.m=m;
		
	}
	public void setCommands()
	{
		comm.put("generate maze",new GenerateMazeCommand());
		comm.put("display maze", new DisplayMazeCommand());
		comm.put("solve maze", new SolveMazeCommand());
		comm.put("display solution", new DisplayMazeCommand());
		comm.put("exit", new ExitCommand());
		v.setCommands(comm);
	}
	@Override
	public void update(Observable o, Object args) {
			//if the view notified the presenter
		   if(o == v) {
			   if((String)args=="start")
				   v.setCommands(comm);
			   else
			   {
					Command newComm=v.getUserCommand();
					newComm.doCommand((String)args);
			   }
		   }
		   
		   //if the model notified the presenter
		   if(o == m) {
			   switch((String)args)
			   {
			   case "Maze was found":
				   v.displayMaze(m.getMaze());
				   break;
			   case "Maze was not found":
				   v.displaySuccess((String)args);
				   break;
			   case "Solution was found":
			   		v.displaySolution(m.getSolution((String)args));
			   		break;
			   case "Solution was not found":
				   v.displaySuccess((String)args);
				   break;
			   case "Maze generated":
				   v.displaySuccess((String)args);
				   break;
			   case "Maze already exists":
				   v.displaySuccess((String)args);
				   break;
			   }
		   }
		}

	public interface Command {
		void doCommand(String arg);
	}
	public class GenerateMazeCommand implements Command {

		@Override
		public void doCommand(String arg) {
			String[] commands=arg.split(" ");
			//check input
			m.generateMaze(commands[0],Integer.parseInt(commands[1]),Integer.parseInt(commands[2]));
			v.displaySuccess("maze"+commands[0]+" is ready");
		}

	}
	public class DisplayMazeCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			m.getMazeInModel(arg);
			
		}
		
	}
	public class SolveMazeCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			m.solveMaze(arg);
			v.displaySuccess("solution for "+arg+" is ready");
			
		}
	}
	public class DisplaySolutionCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			m.getSolutionInModel(arg);
			
		}
		
	}
	public class ExitCommand implements Command
	{

		@Override
		public void doCommand(String arg) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}



