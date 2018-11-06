package medium;

import java.util.*;

public class CourseScheduleII {

    // DFS
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return null;

        // construct the graph
        Map<Integer, List<Integer>> dependent = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            if(dependent.containsKey(prerequisites[i][1]))
                dependent.get(prerequisites[i][1]).add(prerequisites[i][0]);    // 1 -> 0
            else {
                List<Integer> depen_list = new ArrayList<>();
                depen_list.add(prerequisites[i][0]);
                dependent.put(prerequisites[i][1], depen_list);
            }
        }

        Stack<Integer> res = new Stack<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){    // not visited yet
                if(!search(visited, dependent, i, res))
                    return new int[0];
            }
        }

        int[] ordered = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            ordered[i] = res.pop();

        return ordered;
    }

    private boolean search(int[] visited, Map<Integer, List<Integer>> dependent, int cur, Stack<Integer> s){
        if(visited[cur] == -1)  // is currently searching from cur, but come back to cur, hence it is a cycle
            return false;
        if(visited[cur] == 1)   // already searched by other nodes
            return true;

        if(!dependent.containsKey(cur)){  // doesn't have dependents
            visited[cur] = 1;
            s.add(cur);
            return true;
        }

        visited[cur] = -1;
        for(int n:dependent.get(cur)){
            if(!search(visited, dependent, n, s))
                return false;
        }

        visited[cur] = 1;
        s.add(cur);
        return true;
    }
}
