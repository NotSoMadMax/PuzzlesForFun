package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    private static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1 || matrix == null)
        		return Collections.emptyList();
        
        List<Integer> res = new ArrayList<>();
        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        walker(res, matrix, visited, 0, 0, 1, count);
        return res;
    }
    
    private static void walker(List<Integer> res, int[][] matrix, boolean[][] visited, int row, int col, int direction, int count){
    		if (count == matrix.length * matrix[0].length)
    			return;
    		
    		res.add(matrix[row][col]);
    		visited[row][col] = true;
    		count++;
    		
    		if (direction == 1){
    			if (col + 1 < matrix[0].length && !visited[row][col + 1])
    				walker(res, matrix, visited, row, col + 1, 1, count);
    			else
    				walker(res, matrix, visited, row + 1, col, 2, count);
    		} else if (direction == 2) {
			if(row + 1 < matrix.length && !visited[row + 1][col])
				walker(res, matrix, visited, row + 1, col, direction, count);
			else
				walker(res, matrix, visited, row, col - 1, 3, count);
		} else if (direction == 3) {
			if (col - 1 >= 0 && !visited[row][col - 1])
				walker(res, matrix, visited, row, col - 1, direction, count);
			else
				walker(res, matrix, visited, row - 1, col, 4, count);
		} else {	  //direction == 4
			if (row - 1 >= 0 && !visited[row - 1][col])
				walker(res, matrix, visited, row - 1, col, direction, count);
			else 
				walker(res, matrix, visited, row, col + 1, 1, count);			
		}
    		
    		return;
    }
}
