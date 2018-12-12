package Hard;

import java.util.Arrays;

class UF{
    int[] parents;
    int[] rank;
    int[] sizes;    // size of this component

    public UF(int n){
        parents = new int[n];
        rank = new int[n];
        sizes = new int[n];

        for(int i = 0; i < n; i++)
            parents[i] = i;

        Arrays.fill(sizes, 1);
    }

    public int find(int x){
        // if (parents[x] != x)
                //parents[x] = find(parents[x]);
        // return parents[x];

        // iterative
        while (x != parents[x])
            x = parents[x];
        return x;
    }

    public void union(int x, int y){
        int rootx = find(x), rooty = find(y);

        if(rootx == rooty)
            return;

        if(rank[rooty] < rank[rootx]){
            parents[rooty] = rootx;
            sizes[rootx] += sizes[rooty];
        }
        else if(rank[rooty] > rank[rootx])
        {
            parents[rootx] = rooty;
            sizes[rooty] += sizes[rootx];
        }
        else{
            rank[rootx]++;
            parents[rooty] = rootx;
            sizes[rootx] += sizes[rooty];
        }
    }

    public int top(){   // total number of nodes connected to the first row
        int dummy_root = parents.length - 1;
        return sizes[find(dummy_root)] - 1;   // excluding the dummy root itself
    }
}

public class BricksFallingWhenHit {
    int R, C;

    private int to1d(int row, int col){
        return row * C + col;
    }

    private int[] hitBricks(int[][] grid, int[][] hits) {
        R = grid.length;
        C = grid[0].length;

        int[][] broken = new int[R][C];
        for(int i = 0; i < R; i++)
            broken[i] = grid[i].clone();
        for (int[] h:hits)
            broken[h[0]][h[1]] = 0;

        UF u = new UF(R*C+1);   // extra one for dummy root node

        // connected the grids with bricks removed
        for(int i = 0; i < R; i++)
        {
            for(int j = 0; j < C; j++)
            {
                if(broken[i][j] == 1){
                    if(i == 0)
                        u.union(to1d(i, j), R*C);

                    if(i > 0 && broken[i - 1][j] == 1)  // top
                        u.union(to1d(i, j), to1d(i-1, j));
                    if(j > 0 && broken[i][j - 1] == 1)  // left, only one side in each direction is needed
                        u.union(to1d(i, j), to1d(i, j - 1));
                }
            }
        }

        int[][] nei = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int len = hits.length;
        int[] res = new int[len];
        for(int i = len - 1; i >= 0; i--){
            if(grid[hits[i][0]][hits[i][1]] == 0)   // hit nothing, ignore
                continue;

            int prev_reach = u.top();
            int index = to1d(hits[i][0], hits[i][1]);

            for(int dir = 0; dir < 4; dir++)
            {
                int r = hits[i][0] + nei[dir][0];
                int c = hits[i][1] + nei[dir][1];

                if(r >= 0 && r < R && c >= 0 && c < C && broken[r][c] == 1)
                    u.union(index, to1d(r, c));
            }

            if(hits[i][0] == 0)
                u.union(index, R * C);

            res[i] = Math.max(0, u.top() - prev_reach - 1);
            broken[hits[i][0]][hits[i][1]] = 1;
        }

        return res;
    }
}
