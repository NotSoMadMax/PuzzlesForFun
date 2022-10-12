package medium;

public class UniquePaths2 {
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid == null || obstacleGrid[0].length < 1 || obstacleGrid[0] == null || obstacleGrid[0][0] == 1)
        		return 0;

        // dp matrix
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        memo[0][0] = 1;
        // initial first col
        for (int i = 1; i < obstacleGrid.length; i++){
        		if (obstacleGrid[i][0] == 1)    // is obstacle
        			memo[i][0] = 0;
        		else 
				    memo[i][0] = memo[i - 1][0];
        }

        // initial first row
        for (int i = 1; i < obstacleGrid[0].length; i++){
        		if(obstacleGrid[0][i] == 1)
        			memo[0][i] = 0;
        		else
        			memo[0][i] = memo[0][i-1];
        }
        
        for (int r = 1; r < obstacleGrid.length; r++){
        		for(int c = 1; c < obstacleGrid[0].length; c++){
        			if (obstacleGrid[r][c] == 1)
        				memo[r][c] = 0;
        			else
        				memo[r][c] = memo[r - 1][c] + memo[r][c - 1];
        		}
        }
        
        return memo[obstacleGrid.length - 1][obstacleGrid[0].length - 1];        	
    }

    // 2021
	// DP
	public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		if(obstacleGrid[0][0] == 1){
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] paths = new int[m][n];
		paths[0][0] = 1;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if((i == 0 && j == 0) || obstacleGrid[i][j] == 1)
					continue;

				int left = (j == 0 || obstacleGrid[i][j - 1] == 1) ? 0 : paths[i][j - 1];
				int top = (i == 0 || obstacleGrid[i - 1][j] == 1) ? 0 : paths[i - 1][j];

				paths[i][j] = left + top;
			}
		}
		return paths[m - 1][n - 1];
	}
    
}