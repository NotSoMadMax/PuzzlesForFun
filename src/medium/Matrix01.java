package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    // Method 1
    // DFS
    public int[][] updateMatrixDFS(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return null;
        }

        int[][] distance = new int[matrix.length][matrix[0].length];
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                    searchDistanceDFS(matrix, distance, i, j, 0);   // treat 0 as the root and search non-zero entries, depth will be the distance
                }
            }
        }

        return distance;
    }

    private void searchDistanceDFS(int[][] matrix, int[][] distance, int row, int col, int depth) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || distance[row][col] <= depth) {
            return;
        }

        if (matrix[row][col] == 0) {
            depth = 0;
        }
        distance[row][col] = depth;

        searchDistanceDFS(matrix, distance, row - 1, col, depth + 1);
        searchDistanceDFS(matrix, distance, row + 1, col, depth + 1);
        searchDistanceDFS(matrix, distance, row, col + 1, depth + 1);
        searchDistanceDFS(matrix, distance, row, col - 1, depth + 1);
    }

    // Method 2
    // BFS
    public int[][] updateMatrixBFS(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return null;
        }

        int[][] distance = new int[matrix.length][matrix[0].length];
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.add(new int[]{i, j}); // treat 0 as the root and search non-zero entries, depth will be the distance
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : directions) {
                int row = cur[0] + d[0];
                int col = cur[1] + d[1];

                if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
                    continue;
                }

                if (distance[row][col] > distance[cur[0]][cur[1]] + 1) {
                    queue.add(new int[]{row, col});
                    distance[row][col] = distance[cur[0]][cur[1]] + 1;
                }
            }
        }

        return distance;
    }
}





















