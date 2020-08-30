package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Method 1: BFS
    public int maxDepthBFS(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        Node cur;
        while (!queue.isEmpty()) {
            int nOfNodes = queue.size();
            for (int i = 0; i < nOfNodes; i++) {    // for each nodes at this level
                cur = queue.poll();
                queue.addAll(cur.children);
            }
            depth++;
        }
        return depth;
    }

    // Method 2: DFS
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 1;
        for (Node child : root.children) {
            if (child != null) {
                maxDepth = Math.max(maxDepth, maxDepth(child) + 1);
            }
        }

        return maxDepth;
    }
}












