package medium;

import java.util.Arrays;

public class RotateImage {
    static private void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length < 2)	return;
        
        for (int i = 0; i < length/2; i++){
        		for (int j = i; j < length - i - 1; j++)
        			changeThis(i, j, matrix[i][j], matrix, 0);
        }
        
        return;
    }
    
    static private void changeThis(int row, int col, int nextValue, int[][] matrix, int count){    		
		if (count == 4)	return;		
    		int temp = matrix[col][matrix.length - 1 - row];    		
		matrix[col][matrix.length - row - 1] = nextValue;
		count++;
		changeThis(col, matrix.length - row - 1, temp, matrix, count);
		return;
    }
    
    public static void main(String args[]){
    		int[][] matrix = {{1,1,1},
    						{2,2,2},
    						{3,3,3}};
    		for(int[] c : matrix)	System.out.println(Arrays.toString(c));
    		System.out.println("\n");
    		rotate(matrix);
    		for(int[] c : matrix)	System.out.println(Arrays.toString(c));
    		return;
    }
}
