package gameoflife;
import java.util.Random;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Life2 {

	
	
	public static int numRows(boolean[][] cells) {
		return cells.length;
	}
	
	
	public static int numCols(boolean[][] cells) {
		
		if(numRows(cells)>0) {
			return cells[0].length;
		}
		
		return 0;
	}
	
	
	public static boolean isValid(boolean[][] cells,int row,int col) {
		if(row<0||row>=numRows(cells)) {
			return false;
		}
		if(col <0||col>= numCols(cells)) {
			return false;
		}
		
		return true;
		
	}
	
	
	public static boolean[][] clone(boolean[][] cells){
		int rows,cols;

		rows = numRows(cells);
		cols = numCols(cells);
		
		boolean[][] copy = new boolean[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				
				copy[i][j] = cells[i][j];
			}
		}
		return copy;
	}
	
	public static void printCells(boolean[][] cells) {
		for(int i = 0;i<cells.length;i++) {
			for(int j=0;j<cells[0].length;j++) {
				
				if (cells[i][j]) {
					System.out.print("#");
				}else {
					System.out.print("-");
				}
				
			}
			System.out.println();
		}
	}
	
	public static boolean[][] neighborhood(boolean[][] cells,int row,int col) {
		if (!(isValid(cells,row,col))) {
			throw new IllegalArgumentException();
		}
		
		boolean[][] nHood = {{false,false,false},
							 {false,false,false},
							 {false,false,false}};
		
		int left = col-1;
		int top = row-1;
		
		for(int i=0;i<3;i++) {
			int cellsRow = top+i;
			
			for(int j=0;j<3;j++) {
				int cellsCol = left+j;
				
				if (isValid(cells,cellsRow,cellsCol)) {
					
					nHood[i][j] = cells[cellsRow][cellsCol];
				}
			}
		}
		
		return nHood;
	}
	
	
	public static boolean isAlive(boolean[][] cells, int row, int col) {
		/**
		 * Returns true if the specified cell is alive.
		 * 
		 * @param cells a two-dimensional boolean
		 * @param row a row index
		 * @param col a column index
		 * @return true if the specified cell is alive
		 * @throws IllegalArgumentException if row or col is not a valid index for
		 *                                   cells
		 */
		if (!Life2.isValid(cells, row, col)) {
			throw new IllegalArgumentException();
		}
		return cells[row][col];
	}
	
	public static int numAlive(boolean[][] cells) {
		int nAlive = 0;
		
		for(int row=0;row<cells.length;row++) {
			for(int col=0;col<cells[0].length;col++) {
				
				if(cells[row][col]) {
					nAlive ++;
				}
			}
		}
		return nAlive;
	}
	
	public static boolean isBorn(boolean[][] cells, int row, int col) {
		
		boolean[][] neighbors = neighborhood(cells,row,col);
		int nAlive = numAlive(neighbors);
		if(nAlive == 3) {
			return true;
		}
		return false;
		
	}
	
	public static boolean survive (boolean[][] cells, int row, int col) {

		boolean[][] neighbors = neighborhood(cells,row,col);
		int nAlive = numAlive(neighbors);
		if((nAlive == 3)||(nAlive == 4)) {
			return true;
		}
		return false;
	}
	
	public static void evolve(boolean[][] cells) {
		boolean[][] copy = clone(cells);
		for(int i = 0;i<cells.length;i++) {
			for(int j=0;j<cells[0].length;j++) {
				if(cells[i][j] == true) {
					cells[i][j] = survive(copy,i,j);
				}else {
					cells[i][j] = isBorn(copy,i,j);
				}
			}
		}
	}
	public static void randomize(boolean[][]cells) {
		Random rand = new Random();
		for(int i=0;i<cells.length;i++) {
			for(int j=0;j<cells[i].length;j++) {
				cells[i][j] = rand.nextBoolean();
			}
		}
	}
	
	public static boolean insert(boolean[][] pattern,int row,int col,boolean[][] cells) {
		if(row<0||col<0) {
			throw new IllegalArgumentException();
		}
		
		int rowRemain = cells.length - row - pattern.length;
		int colRemain = cells[0].length - col - pattern[0].length;
		if(rowRemain<0||colRemain<0) {
			return false;
		}
		for(int i=0;i<pattern.length;i++) {
			for(int j=0;j<pattern[0].length;j++) {
				cells[row+i][col+j] = pattern[i][j];
			}
		}
		return true;
	}
	
	
}
