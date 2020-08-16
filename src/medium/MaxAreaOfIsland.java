package medium;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = search(grid, i, j);
                    maxArea = Integer.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int search(int[][] grid, int row, int col) {
        int nOfRow = grid.length;
        int nOfCol = grid[0].length;
        int area = 0;

        if (row < 0 || row >= nOfRow || col < 0 || col >= nOfCol || grid[row][col] != 1) {
            return area;
        }

        area += 1;
        grid[row][col] = -1;

        area += search(grid, row - 1, col);
        area += search(grid, row + 1, col);
        area += search(grid, row, col - 1);
        area += search(grid, row, col + 1);

        return area;
    }
}
