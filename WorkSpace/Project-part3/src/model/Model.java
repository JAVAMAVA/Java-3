package model;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public interface Model {
	void generateMaze(String name,int rows,int cols); 
	void solveMaze(String name); 
	Solution getSolution(String name); 
	void stop();
	Maze getMaze();
	void getMazeInModel(String arg);
	void getSolutionInModel(String arg);

}
