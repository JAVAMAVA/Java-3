package model;

import java.util.Observer;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public interface Model {
	void generateMaze(int rows,int cols); 
	Maze getMaze(); 
	void solveMaze(Maze m); 
	Solution getSolution(); 
	void stop();
	void addobserver(Observer observer);

}
