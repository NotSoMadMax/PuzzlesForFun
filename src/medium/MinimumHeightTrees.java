package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTrees {

    // Method 1: BFS starts with leaves, the final level will be the roots of MHT
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            return Collections.singletonList(0);
        }

        Map<Integer, Set<Integer>> neighbors = new HashMap(n);
        for (int[] edge : edges) {
            neighbors.putIfAbsent(edge[0], new HashSet<Integer>());
            neighbors.putIfAbsent(edge[1], new HashSet<Integer>());
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // Add all leaves to the queue
        neighbors.entrySet().stream()
                .filter(e -> (e.getValue().size() == 1))
                .forEach(e -> queue.add(e.getKey()));

        // While haven't reached the roots level yet
        while (n > 2) {
            int nOfNodes = queue.size();
            for (int i = 0; i < nOfNodes; i++) {
                Integer cur = queue.poll();

                // remove cur from the neighbor's list
                for (Integer neighbor : neighbors.get(cur)) {
                    neighbors.get(neighbor).remove(cur);
                    if (neighbors.get(neighbor).size() == 1) {
                        queue.add(neighbor);
                    }
                }
                n--;
            }
        }

        return new ArrayList<>(queue);
    }
}
