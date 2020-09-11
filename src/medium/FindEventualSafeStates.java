package medium;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // -1: not safe, 0 : not visited yet, 1: safe
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            DFSSearchSafe(i, graph, visited);
        }

        return IntStream.range(0, graph.length)
                .boxed()
                .filter(i -> visited[i] == 1)
                .collect(Collectors.toList());
    }

    private boolean DFSSearchSafe(int cur, int[][] graph, int[] visited) {
        if (visited[cur] != 0) {
            return visited[cur] == 1;
        }

        visited[cur] = -1;  // first assume it is unsafe, so it will return when there is a loop when reached
        if (graph[cur] != null && graph[cur].length >= 1) {
            for (int i : graph[cur]) {
                if (!DFSSearchSafe(i, graph, visited)) { // all paths should end up at a safe node
                    return false;
                }
            }
        }
        visited[cur] = 1;

        return visited[cur] == 1;
    }
}
