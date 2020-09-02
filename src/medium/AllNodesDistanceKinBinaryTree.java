package medium;

import java.util.*;

class AllNodesDistanceKinBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Method 1: Graph + BFS
    private List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();

        buildGraph(neighbors, root, null);

        // BFS search in graph
        Queue<Integer> q = new ArrayDeque<>();
        q.add(target.val);
        boolean[] visited = new boolean[501];
        visited[target.val] = true;

        List<Integer> res = new ArrayList<>();
        int dist = 0;
        while (!q.isEmpty() && dist <= K) {
            int cur_size = q.size();

            while (cur_size > 0) {
                int cur = q.poll();
                if (dist == K)
                    res.add(cur);

                for (int child : neighbors.get(cur)) {
                    if (visited[child])
                        continue;
                    q.add(child);
                    visited[child] = true;
                }
                cur_size--;
            }

            dist++;
        }

        return res;
    }

    private void buildGraph(Map<Integer, List<Integer>> neighbors, TreeNode cur, TreeNode parent) {
        if (cur == null)
            return;

        List<Integer> nei = new ArrayList<>();
        if (parent != null)
            nei.add(parent.val);
        if (cur.left != null)
            nei.add(cur.left.val);
        if (cur.right != null)
            nei.add(cur.right.val);

        neighbors.put(cur.val, nei);

        buildGraph(neighbors, cur.left, cur);
        buildGraph(neighbors, cur.right, cur);
    }

    // 2020
    // Method 2: recursion
    public List<Integer> distanceKBFS(TreeNode root, TreeNode target, int K) {
		List<Integer> response = new ArrayList<>();
		findDistance(response, root, target, K);
		return response;
    }

    // Find distance from cur to target
    private int findDistance(List<Integer> response, TreeNode cur, TreeNode target, int k) {
    	if (cur == null) {
			return -1;	// indicating target is not found
		}

    	if (cur.val == target.val) {
    		findDistanceKFromBelow(response, cur, k);
    		return 0;
		}

    	int l = findDistance(response, cur.left, target, k);
		int r = findDistance(response, cur.right, target, k);

		if (l >= 0) {	// find target in left tree
			if (l == k - 1) {  // the search start from cur.left, so k - 1
				response.add(cur.val);
			}
			findDistanceKFromBelow(response, cur.right, k - l - 2); // search to see if it's in right tree
			return l + 1;
		}

		if (r >= 0) {
			if (r == k - 1) {
				response.add(cur.val);
			}
			findDistanceKFromBelow(response, cur.left, k - r - 2);
			return r + 1;
		}

		return -1;
	}


    // DFS search all sub nodes that is d away from root
    private void findDistanceKFromBelow(List<Integer> response, TreeNode root, int d) {
		if (root == null || d < 0) {
			return;
		}

		if (d == 0) {
			response.add(root.val);
		}

		findDistanceKFromBelow(response, root.left, d - 1);
		findDistanceKFromBelow(response, root.right, d - 1);
	}




}














