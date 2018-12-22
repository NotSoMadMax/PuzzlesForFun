package medium;

import java.util.ArrayList;

class NumberOfCornerRectangles {

	// Method 1: Brutal Force
    private int countCornerRectangles1(int[][] grid) {
        if(grid == null || grid.length < 1)
        	return 0;
        
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row - 1; i++){
        	for(int j = 0; j < col - 1; j++){
        		if(grid[i][j] == 1)
        			res += check(i, j, grid);
        	}
        }
        
        return res;
    }
    
    private int check(int r, int c, int[][] grid){
    	int res = 0;
    	
    	for(int i = r + 1; i < grid.length; i++){
    		for(int j = c + 1; j < grid[0].length; j++){
    			if(grid[i][j] == 1){
    				if(grid[r][j] == 1 && grid[i][c] == 1)
    					res++;
    			}
    		}
    	}
    	
    	return res;
    }
    
    //Method 2: Row and Row
    private int countCornerRectangles2(int[][] grid) {
        if(grid == null || grid.length < 1)
        	return 0;
        
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++)
        {
        	for(int j = i + 1; j < row; j++)
        	{
        		int count = 0;
        		for(int c = 0; c < col; c++)
        		{
        			if(grid[i][c] == 1 && grid[j][c] == 1)
        				count++;
        		}
        		res += 0.5 * count * (count - 1);
        	}
        }
        
        return res;
    }
    
    // Method 3: Row and Row, improved
    private int countCornerRectangles3(int[][] grid) {
        if(grid == null || grid.length < 1)
        	return 0;
        
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++)
        {	
        	ArrayList<Integer> ones = new ArrayList<>();
        	for(int x = 0; x < col; x++){
        		if(grid[i][x] == 1)
        			ones.add(x);
        	}
        	
        	for(int j = i + 1; j < row; j++)
        	{
        		int count = 0;
        		for(int c:ones)
        		{
        			if(grid[j][c] == 1)
        				count++;
        		}
        		res += 0.5 * count * (count - 1);
        	}
        }
        
        return res;
    }
}















