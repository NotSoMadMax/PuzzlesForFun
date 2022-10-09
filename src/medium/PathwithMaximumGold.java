class Solution {
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, search(grid, i, j));
            }
        }
        return res;
    }
    
    
    int[][] COR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int search(int[][] grid, int row, int col) {  // the maximum amount if start at (row, col)
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }
        if(grid[row][col] == 0) {
            return 0;
        }
        
        int cellValue = grid[row][col];
        grid[row][col] = 0; // mark as visited
        
        int maxValue = 0;
        for(int i = 0; i < 4; i++) {
            int r = row + COR[i][0];
            int c = col + COR[i][1];
            
            maxValue = Math.max(maxValue, search(grid, r, c));
        }
        grid[row][col] = cellValue;
        
        return cellValue + maxValue;
    }
}