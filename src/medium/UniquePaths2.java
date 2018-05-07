package medium;

public class UniquePaths2 {
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid == null || obstacleGrid[0].length < 1 || obstacleGrid[0] == null || obstacleGrid[0][0] == 1)
        		return 0;
        
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        memo[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++){
        		if (obstacleGrid[i][0] == 1)
        			memo[i][0] = 0;
        		else 
				memo[i][0] = memo[i - 1][0];		
        }
        
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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
