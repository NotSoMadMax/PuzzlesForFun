package medium;

class MaximalSquare {
    private int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int result = 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];

        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }

                else if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;

                }
                if(dp[i][j] > result)
                    result = dp[i][j];

            }
        }

        return result * result;
    }
}
