package medium;


class NumberOfIslands {

	// Method 1: DFS
	private int numIslands(char[][] grid) {
		if(grid == null || grid.length < 1 || grid[0].length < 1)
			return 0;

		int res = 0;
		for (int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == '1'){
					res++;
					search(grid, i, j);
				}
			}
		}

		return res;
    }


	private void search(char[][] grid, int row, int col){
		if(row > grid.length - 1 || row <0 || col > grid[0].length - 1 || col < 0)	// out of bound
			return;

		if(grid[row][col] == '0' || grid[row][col] == 'x')	// is sea, or visited
			return;

		grid[row][col] = 'x';

		search(grid, row + 1, col);
		search(grid, row - 1, col);
		search(grid, row, col + 1);
		search(grid, row, col - 1);
	}

	// Method 2: Union Find
	private int numIslands2(char[][] grid) {
		if(grid == null || grid.length < 1 || grid[0].length < 1)
			return 0;

		uf u = new uf(grid);

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == '1')
				{
					grid[i][j] = 'x'; // label as visited

					if (i - 1 >= 0 && grid[i-1][j] == '1')
						u.union(u.to1d(i,j), u.to1d(i-1, j));

					if (i + 1 < grid.length && grid[i+1][j] == '1')
						u.union(u.to1d(i,j), u.to1d(i+1, j));

					if (j - 1 >= 0 && grid[i][j-1] == '1')
						u.union(u.to1d(i,j), u.to1d(i,j - 1));

					if (j + 1 < grid[0].length && grid[i][j+1] == '1')
						u.union(u.to1d(i,j), u.to1d(i,j + 1));

				}
			}
		}

		return u.getCount();
	}


	class uf{
		int count; // number of connected component
		int[] parent;
		int[] rank;
		int rn;
		int cn;

		public uf(char[][] grid){
			count = 0;
			rn = grid.length;
			cn = grid[0].length;

			parent = new int[rn * cn];
			rank = new int[rn * cn];

			for(int i = 0; i < rn; i++){
				for(int j = 0; j < cn; j++){
					if(grid[i][j] == '1')
					{
						parent[to1d(i, j)] = to1d(i, j);
						count++;
					}
				}
			}

			return;
		}

		public int find(int x){
			while (parent[x] != x)
			{
				parent[x] = parent[parent[x]];
				x = parent[x];
			}

			return x;
		}

		public void union(int x, int y){
			int rootx = find(x);
			int rooty = find(y);

			if(rootx == rooty)
				return;

			if(rank[rootx] < rank[rooty])
				parent[rootx] = rooty;
			else if(rank[rootx] > rank[rooty])
				parent[rooty] = rootx;
			else {
				parent[rootx] = rooty;
				rank[rooty]++;
			}

			count--;
		}

		public int to1d(int r, int c){
			return cn * r + c;
		}

		public int getCount(){
			return count;
		}
	}
}
