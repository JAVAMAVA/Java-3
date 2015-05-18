package model;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import algorithms.demo.MazeDomain;
import algorithms.mazeGenerators.DFSMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.search.AStar;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.TestSearcher;

/**
 * 
 * MyModel is an observable type class from the MVP pattern that implements Model
 * 
 * @author Michael & Amit
 * @see Model
 * @see java.util.Observable
 * 
 */

public class MyModel extends java.util.Observable implements Model { 
	
	ThreadPoolExecutor pool;
	HashMap<Maze,Solution> mazeSolutions;
	HashMap<String,Maze> mazeNames;
	Maze currMaze;
	Solution currSol;
	public MyModel() {
		pool = new ThreadPoolExecutor(0, 0, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4));
		HashMap<Maze,Solution> mazeSolutions = new HashMap<Maze,Solution>();
		HashMap<String,Maze> mazeNames = new HashMap<String, Maze>();
	}
	/**
	 * generateMaze is a public method for generating a maze
	 * the method uses the threadpool
	 * @param maze hold the generated maze 
	 *  
	 */

	@Override
	public void generateMaze(String name,int rows, int cols ) { 
		System.out.println("Generating Maze");
		Maze maze = null;
		checkMaze(name);
		Future<Maze> m = pool.submit(new Callable<Maze>(){
			@Override
			public Maze call() throws Exception {
				DFSMazeGenerator dm = new DFSMazeGenerator();
				return (dm.generateMaze(rows, cols));
			}
		}
		);
		try {
			maze  = m.get();
			mazeNames.put(name, maze);
			currMaze = maze;
			setChanged();
			notifyObservers("Maze generated");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * getMaze sends the maze that was generated last
	 */
	@Override
	public Maze getMaze() {
		return currMaze;
	}
	/**
	 * solveMaze a public method that gets a maze name, and solves the main if exists
	 * the method uses the threadpool pool
	 * @param solution holds the solution that was made
	 */
	@Override
	public void solveMaze(String name) {
		System.out.println("Solving Maze");
		Solution solution;
		
		Future<Solution> sm = pool.submit(new Callable<Solution>(){

			@Override
			public Solution call() throws Exception {
				NewMazeDomain m = new NewMazeDomain(matrix, start, goal);
				m.setMatrix(mazeNames.get(name));
				Solution s = new Solution();
				TestSearcher ts = new TestSearcher();
				ts.Test(new AStar(),m );
				
				return ts.getSolutionSearcher();
			}	
		});
		try {
			solution = sm.get();
			currSol = solution;
			setChanged();
			notifyObservers("maze solved");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * getSolution sends the solution that was generated last
	 */
	@Override
	public Solution getSolution(String name) {	
		return currSol;
	}

	@Override
	public void stop() {
		
		
		
	}
	/**
	 * this method checks if the maze solution is already in the hashmap
	 * @param mazeName used to check if solution exists already 
	 */
	
	public void checkSolution(String name){
		Maze m;
		if(mazeNames.get(name) != null){
			currMaze = mazeNames.get(name);
			if(mazeSolutions.get(currMaze) != null){
				setChanged();
				notifyObservers("solution found");
			}
			else{
				setChanged();
				notifyObservers("solution not found");
			}
		}
		else{
			setChanged();
			notifyObservers("maze not found");
		}
	}
	/**
	 * the method checks if the maze exists
	 * @param name the maze name we got
	 */
	public void checkMaze(String name){
		Maze m;
		if(mazeNames.get(name) != null){
			currMaze = mazeNames.get(name);
			setChanged();
			notifyObservers("Maze already exists");
		}
	}
	
	public void saveToFile(){
		
		
	}
	/**
	 * the method gets the maze from the hashtable if exists and notifies the Observer
	 */
	@Override
	public void getMazeInModel(String arg) {
		if(mazeNames.get(arg)!=null)
		{
			setChanged();
			currMaze=mazeNames.get(arg);
			notifyObservers("Maze was found");
				
		}
		else {
			setChanged();
			notifyObservers("Maze was not found");
			}
		
		
	}
	/**
	 *  the method gets the solution from the hashtable if exists and notifies the Observer
	 */
	@Override
	public void getSolutionInModel(String arg) {
		if(mazeSolutions.get(arg)!=null)
		{
			setChanged();
			currSol=mazeSolutions.get(arg);
			notifyObservers("Solution was found");
				
		}
		else {
			setChanged();
			notifyObservers("Solution was not found");
			}
		
	}
	
	
}
