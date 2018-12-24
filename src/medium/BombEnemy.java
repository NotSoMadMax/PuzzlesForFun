package medium;

class BombEnemy {
	
	// Method 1: Memo, preSum, 10ms
	private int maxKilledEnemies1(char[][] grid) {
        if(grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1)
        	return 0;
        
        int row = grid.length, col = grid[0].length;
        int[][] pre_sum_row = new int[row][col];
        
        // row sum
        for(int i = 0; i < row; i++){
        	int count = 0;
        	for(int j = 0; j < col; j++){	// left to right
        		if(grid[i][j] == 'W')
        			count = 0;
        		else if(grid[i][j] == 'E')
        			count++;
        		else
        			pre_sum_row[i][j] = count;
        	}
        	
        	count = 0;
        	for(int j = col - 1; j >= 0; j--){	// right to left
        		if(grid[i][j] == 'W')
        			count = 0;
        		else if(grid[i][j] == 'E')
        			count++;
        		else
        			pre_sum_row[i][j] += count;
        	}
        }
        
        // col sum
        int[][] pre_sum_col = new int[row][col];
        for(int j = 0; j < col; j++){
        	int count = 0;
        	for(int i = 0; i < row; i++){
        		if(grid[i][j] == 'W')
        			count = 0;
        		else if(grid[i][j] == 'E')
        			count++;
        		else
        			pre_sum_col[i][j] = count;
        	}
        	
        	count = 0;
        	for(int i = row - 1; i >= 0; i--){
        		if(grid[i][j] == 'W')
        			count = 0;
        		else if(grid[i][j] == 'E')
        			count++;
        		else
        			pre_sum_col[i][j] += count;
        	}
        }
        
        int res = 0;
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if(grid[i][j] == '0')
        			res = Math.max(res, pre_sum_col[i][j]+pre_sum_row[i][j]);
        	}
        }
        
        return res;
    }
}


















