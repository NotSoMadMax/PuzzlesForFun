package medium;

public class Searcha2DMatrixII {
	// Method 1: Manhattan Search
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0] == null)
        	return false;
        
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        int i = nRow - 1;
        int j = 0;
        while(i >= 0 && j < nCol) {
        	if(matrix[i][j] == target)
        		return true;
        	else if(matrix[i][j] > target)
        		i--;
        	else
        		j++;        			
        }
        
        return false;
    }
}
