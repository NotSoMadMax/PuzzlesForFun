package medium;


public class NumberOfIslands {
    	
	public int numIslands(char[][] grid) {
		int len = grid.length;
		if (len < 1 || grid == null)		return 0;
		
		char[][] visited = new char[grid.length][];
		for (int i = 0; i < grid.length; i++)
			visited[i] = grid[i].clone();		// '1': not visited  '0': visited
		
		int result = 0;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (grid[i][j] == '1' && visited[i][j] == '1'){
					explore(i, j, visited, grid);
					result++;
				}
			}
		}		
		
		return result;
    }	
	
	
	static private void explore(int row, int col, char[][] visited, char[][] grid){		
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
			return;
		if (grid[row][col] == '0' || visited[row][col] == '0')
			return;
		
		visited[row][col] = '0';
		explore(row, col - 1, visited, grid);
		explore(row, col + 1, visited, grid);
		explore(row - 1, col, visited, grid);
		explore(row + 1, col, visited, grid);
		
		return;
	}
	
	public static void main(String[] args) {
		
	}
}
