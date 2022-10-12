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
    class Cor {

        // ideally should be private and access through get method, but I'm lazy
        int row;
        int col;
        
        public Cor(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
    }

    public int[][] updateMatrixBFS(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return null;
        }
        
        Queue<Cor> queue = new LinkedList<>();
        int[][] results = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    results[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.add(new Cor(i, j));
                }
            }
        }
        
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(!queue.isEmpty()) {
            Cor cur = queue.poll();
            
            for(int[] dir:directions) {
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
                    continue;
                }
                if (results[row][col] <= results[cur.row][cur.col] + 1) {
                    continue;
                }
                results[row][col] = results[cur.row][cur.col] + 1;
                queue.add(new Cor(row, col));
            }
        }
            
        return results;        
    }
}





















