package medium;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];

        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                DFSSearch(i, M, visited);
                res++;
            }
        }

        return res;
    }

    private void DFSSearch(int cur, int[][] graph, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < graph[cur].length; i++) {
            if (graph[cur][i] == 1 && !visited[i]) {
                DFSSearch(i, graph, visited);
            }
        }
    }
}
