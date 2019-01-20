package Hard;

import java.util.*;

class CutOffTreesforGolfEvent {
    int[][] direc = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    private int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.isEmpty())
            return 0;

        TreeMap<Integer, int[]> heights = new TreeMap<>();  // Height -> coordinate
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1)
                    heights.put(forest.get(i).get(j), new int[]{i, j});
            }
        }

        int n_trees = heights.size();
        int res = 0;
        int[] cur = new int[]{0, 0};
        for(int i = 0; i < n_trees; i++){
            int[] next = heights.pollFirstEntry().getValue();

            int distance = search(forest, cur[0], cur[1], forest.get(next[0]).get(next[1]));
            if(distance == -1)
                return -1;

            res += distance;
            cur[0] = next[0];
            cur[1] = next[1];
        }

        return res;
    }

    // BFS search
    private int search(List<List<Integer>> forest, int r, int c, int target){
        if(forest.get(r).get(c) == target)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        q.add(new int[]{r, c});
        visited[r][c] = true;

        int distance = -1;
        while (!q.isEmpty()){
            distance++;

            int level_size = q.size();
            for(int l = 0; l < level_size; l++){
                int[] cur = q.poll();

                if(forest.get(cur[0]).get(cur[1]) == target)
                    return distance;

                for(int i = 0; i < 4; i++){
                    int row = cur[0] + direc[i][0], col = cur[1] + direc[i][1];

                    if(row < 0 || row >= forest.size() || col < 0 || col >= forest.get(0).size())
                        continue;

                    if(!visited[row][col] && forest.get(row).get(col) > 0){
                        q.add(new int[]{row, col});
                        visited[row][col] = true;
                    }
                }
            }
        }

        return -1;
    }
}












