package model;

import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public class MyModel extends Observable implements Model {

	@Override
	public void generateMaze(int rows, int cols) {
		System.out.println("Generating Maze");
		notifyObservers();
		
	}@Override
	public void addobserver(Observer observer)
	{
		this.addObserver(observer);
	}

	@Override
	public Maze getMaze() {
		System.out.println("getting maze");
		return null;
	}

	@Override
	public void solveMaze(Maze m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Solution getSolution() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
