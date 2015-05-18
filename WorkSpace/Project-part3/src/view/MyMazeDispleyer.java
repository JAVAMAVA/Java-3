package view;

import presenter.Presenter.DisplayMazeCommand;
import algorithms.mazeGenerators.Maze;
/**
 * {@link MyMazeDispleyer} implements {@link MazeDispleyer} 
 * this class got the display method that prints out a maze
 * @author user
 *
 */
public class MyMazeDispleyer implements MazeDispleyer {
	
	/**
	 * display method displays a maze in the console
	 */
	@Override
	public void display(Maze matrix) {
		for (int j = 0; j < matrix.getCols(); j++)
			System.out.print(" _");
		System.out.println("");
	
		
		for (int i = 0; i < matrix.getRows(); i++) {
			System.out.print("|");
			for (int j = 0; j < matrix.getCols(); j++) {				
				if (matrix.getCell(i, j).getDown())
					System.out.print("_");
				else
					System.out.print(" ");
				
				if (matrix.getCell(i, j).getRight())
					System.out.print("|");
				else
					System.out.print(" ");	
								
			}
			System.out.println();
		}
		
	}

}
