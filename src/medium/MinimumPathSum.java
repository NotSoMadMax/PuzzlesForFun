package medium;

public class MinimumPathSum {
    private int minPathSum(int[][] grid) {
        if(grid.length < 1 || grid == null || grid[0].length < 1 || grid[0]==null)
        		return 0;
        
        int[][] memo = new int[grid.length][grid[0].length];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++)
        		memo[i][0] = memo[i-1][0] + grid[i][0];
        
        for (int i = 1; i < grid[0].length; i++)
        		memo[0][i] = memo[0][i - 1] + grid[0][i];
        
        for (int i = 1; i < grid.length; i++){
        		for (int j = 1; j < grid[0].length; j++){
        			if (memo[i-1][j] > memo[i][j-1])
        				memo[i][j] = memo[i][j-1] + grid[i][j];
        			else
        				memo[i][j] = memo[i-1][j] + grid[i][j];
        		}
        }
        
        return memo[grid.length - 1][grid[0].length - 1];
    }
}






