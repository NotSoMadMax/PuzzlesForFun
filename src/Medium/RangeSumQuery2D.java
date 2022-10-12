package medium;

class RangeSumQuery2D {


    int[][] dp;
    public void NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return;

        int r = matrix.length;
        int c = matrix[0].length;
        dp = new int[r][c];
        dp[0][0] = matrix[0][0];

        for(int i = 1; i < r; i++)
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        for(int j = 1; j < c; j++)
            dp[0][j] = dp[0][j - 1] + matrix[0][j];

        for (int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null)
            return 0;

        if (row1 == 0 && col1 == 0)
            return dp[row2][col2];
        if(row1 == 0)
            return  dp[row2][col2] - dp[row2][col1 - 1];
        if(col1 == 0)
            return dp[row2][col2] - dp[row1 - 1][col2];

        return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
    }
}
