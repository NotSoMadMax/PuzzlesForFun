package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PacificAtlanticWaterFlow {
    private List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length < 1)
            return Collections.emptyList();

        int r = matrix.length, c = matrix[0].length;
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for(int i = 0; i < r; i++){
            pacific[i][0] = true;
            search(i, 0, matrix, pacific);

            atlantic[i][c - 1] = true;
            search(i, c - 1, matrix, atlantic);
        }

        for(int j = 0; j < c; j++){
            pacific[0][j] = true;
            search(0, j, matrix, pacific);

            atlantic[r - 1][j] = true;
            search(r - 1, j, matrix, atlantic);
        }

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }

        return res;
    }

    private void search(int cur_r, int cur_c, int[][] matrix, boolean[][] visited){
        int r = matrix.length, c = matrix[0].length;

        int[] direc_r = {0, -1, 0, 1};
        int[] direc_c = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++){
            int nextr = cur_r + direc_r[i];
            int nextc = cur_c + direc_c[i];

            if(nextr < 0 || nextr >= r || nextc < 0 || nextc >= c)
                continue;
            if(visited[nextr][nextc])
                continue;
            if(matrix[nextr][nextc] < matrix[cur_r][cur_c])
                continue;

            visited[nextr][nextc] = true;
            search(nextr, nextc, matrix, visited);
        }

        return;
    }
}
