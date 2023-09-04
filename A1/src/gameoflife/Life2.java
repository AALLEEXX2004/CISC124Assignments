package gameoflife;


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

}
