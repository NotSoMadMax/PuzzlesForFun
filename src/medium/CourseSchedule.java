package medium;

import java.util.*;

public class CourseSchedule {

    // Method 1: DFS, 82%
    private boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length < 1)
            return true;

        Map<Integer, List<Integer>> dependent = new HashMap<>();
        int len = prerequisites.length;

        // construct the graph
        for(int i = 0; i < len; i++){
            if(dependent.containsKey(prerequisites[i][1]))
                dependent.get(prerequisites[i][1]).add(prerequisites[i][0]);    // 1 -> 0
            else {
                List<Integer> depen_list = new ArrayList<>();
                depen_list.add(prerequisites[i][0]);
                dependent.put(prerequisites[i][1], depen_list);
            }
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){    // not visited yet
                if(!topoSearch(visited, dependent, i))
                    return false;
            }
        }

        return true;
    }


    private boolean topoSearch(int[] visited, Map<Integer, List<Integer>> dependent, int cur){
        if(visited[cur] == -1)  // is currently searching from cur, but come back to cur, hence it is a cycle
            return false;
        if(visited[cur] == 1)   // already searched by other nodes
            return true;

        if(!dependent.containsKey(cur)){  // doesn't have dependents
            visited[cur] = 1;
            return true;
        }

        visited[cur] = -1;
        for(int n:dependent.get(cur)){
            if(!topoSearch(visited, dependent, n))
                return false;
        }

        visited[cur] = 1;

        return true;
    }


    // Method 2: BFS
    private boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        return false;
    }
}
