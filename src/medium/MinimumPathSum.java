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

    // 2020
    // 2D DP
    private int minPathSum1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] mins = new int[rows][cols];
        mins[0][0] = grid[0][0];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0)
                    continue;
                int left = j == 0 ? Integer.MAX_VALUE : mins[i][j - 1];
                int top = i == 0 ? Integer.MAX_VALUE : mins[i - 1][j];
                mins[i][j] = grid[i][j] + Math.min(left, top);
            }
        }

        return mins[rows - 1][cols - 1];
    }

    // 2D DP
    // Memory optimization
    private int minPathSum2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0)
                    continue;
                int left = j == 0 ? Integer.MAX_VALUE : grid[i][j - 1];
                int top = i == 0 ? Integer.MAX_VALUE : grid[i - 1][j];
                grid[i][j] += Math.min(left, top);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}






