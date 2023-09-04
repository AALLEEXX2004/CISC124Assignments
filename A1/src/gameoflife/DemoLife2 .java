package gameoflife;

import java.util.Arrays;

public class DemoLife2 {
	public static void main(String[] args) {
		int rows,cols;
		boolean[][] copy, neigh;
		boolean[][] cells = {{false,false,false,false,false},
				 			 {false,false,false,false,false},
				 			 {false,false,false,true,false}};
		
		rows = Life2.numRows(cells);
		cols = Life2.numCols(cells);
		
		System.out.println("number of rows ="+ rows);
		System.out.println("number of columns ="+ cols);
		
		System.out.println("is valid ="+ Life2.isValid(cells, 0, 0));
		System.out.println("is valid ="+ Life2.isValid(cells, rows, 0));
		System.out.println("is valid ="+ Life2.isValid(cells, 0, cols));
		
		copy = Life2.clone(cells);
		String copyString = Arrays.deepToString(copy);
		
		System.out.println("copy ="+ copyString);
		
		Life2.printCells(copy);
		
		neigh = Life2.neighborhood(cells, 1, 3);
		Life2.printCells(neigh);
		
		neigh = Life2.neighborhood(cells, 2, 4);
		Life2.printCells(neigh);
		
		System.out.println("is alive ="+Life2.isAlive(cells, 0, 0));
		System.out.println("is alive ="+ Life2.isAlive(cells, 2, 3));
		
		cells = new boolean[][] {{true,true},
								{true,false}};
		
		Life2.printCells(cells);
		System.out.println("num alive ="+ Life2.numAlive(cells));
	}
	
}
