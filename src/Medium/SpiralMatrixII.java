package medium;

import java.util.Collections;
import java.util.List;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
    		int[][] res = new int[n][n];    
    		if (n < 1)
        		return res;
                
        boolean[][] visited = new boolean[n][n];
        walker(res, visited, 0, 0, 1, 0);
        return res;
    }	
	
	
    private static void walker(int[][] matrix, boolean[][] visited, int row, int col, int direction, int count){
		if (count == matrix.length * matrix[0].length)
			return;
		
		matrix[row][col] = count + 1;
		visited[row][col] = true;
		count++;
		
		if (direction == 1){
			if (col + 1 < matrix[0].length && !visited[row][col + 1])
				walker(matrix, visited, row, col + 1, 1, count);
			else
				walker(matrix, visited, row + 1, col, 2, count);
		} else if (direction == 2) {
		if(row + 1 < matrix.length && !visited[row + 1][col])
			walker(matrix, visited, row + 1, col, direction, count);
		else
			walker(matrix, visited, row, col - 1, 3, count);
	} else if (direction == 3) {
		if (col - 1 >= 0 && !visited[row][col - 1])
			walker(matrix, visited, row, col - 1, direction, count);
		else
			walker(matrix, visited, row - 1, col, 4, count);
	} else {	  //direction == 4
		if (row - 1 >= 0 && !visited[row - 1][col])
			walker(matrix, visited, row - 1, col, direction, count);
		else 
			walker(matrix, visited, row, col + 1, 1, count);			
	}
		
		return;
    }	
}
