package medium;

public class SetMatrixZeros {
    public static void setRowZero(int[][] matrix, int r, int recordRow){
        
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[r][i] == 0)
                matrix[recordRow][i] = -1;
            else
                matrix[r][i] = 0;
        }
        
        return;
    }
    
    public static void setColZero(int[][] matrix, int c){
        for (int i = 0; i < matrix.length; i++){
            matrix[i][c] = 0;
        }
        
        return;
    }
    
    // constant space complexity
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        if (r < 1 || matrix == null || c < 1 || matrix[0] == null)
            return;
        if(r == 1 && c == 1)
            return;
        
        int recordRow = -1;
        
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (matrix[i][j] == 0){
                    if (recordRow == -1){
                        recordRow = i;
                    }                            
                    setRowZero(matrix, i, recordRow);   
                    break;
                }                    
            }
        }
        
        if (recordRow != -1){
            for (int i = 0; i < c; i++){
                if (matrix[recordRow][i] == -1){
                    setColZero(matrix, i);
                    matrix[recordRow][i] = 0;
                }                    
            }
        }

        return;
    }
}
