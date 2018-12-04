package medium;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemovedwithSameRoworColumn {
    private int removeStones(int[][] stones) {
        if(stones == null || stones.length < 1)
            return 0;

        int len = stones.length;

        // construct neighbor graph
        List<List<Integer>> neighbors = new ArrayList<>();
        for(int i = 0; i < len; i++)
            neighbors.add(new ArrayList<>());

        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    neighbors.get(i).add(j);
                    neighbors.get(j).add(i);
                }
            }
        }

        int ans = 0;
        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++)
        {
            if(!visited[i]){
                ans--;
                ans += search(i, neighbors, visited);
            }
        }

        return ans;
    }


    private static int search(int cur, List<List<Integer>> neighbors, boolean[] visited){
        if(visited[cur])
            return 0;
        visited[cur] = true;
        int ans = 1;
        for(int n: neighbors.get(cur))
        {
            ans += search(n, neighbors, visited);
        }

        return ans;
    }
}
