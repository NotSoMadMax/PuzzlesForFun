package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {

    // Method 1: BFS
    public int maxDistanceBFS(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // All water or all land
        if (queue.isEmpty() || queue.size() == grid.length * grid.length) {
            return -1;
        }

        int steps = 0;
        int[] cur;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int nOdNodes = queue.size();

            for (int i = 0; i < nOdNodes; i++) {
                cur = queue.poll();
                for (int[] direction : directions) {
                    int row = cur[0] + direction[0];
                    int col = cur[1] + direction[1];

                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                        continue;
                    }

                    if (grid[row][col] == 0) {
                        queue.add(new int[]{row, col});
                        grid[row][col] = 1;     // mark it as visited
                    }
                }
            }
            steps++;
        }

        return steps - 1;
    }
}
