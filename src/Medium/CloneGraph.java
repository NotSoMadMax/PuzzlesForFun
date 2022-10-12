package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Method 1: BFS
    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Node[] copied = new Node[101]; // old node -> copied node
        queue.add(node);
        copied[node.val] = new Node(node.val);

        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (Node n : cur.neighbors) {
                if (copied[n.val] == null) {    // not copied yet
                    copied[n.val] = new Node(n.val);
                    queue.add(n);
                }
                copied[cur.val].neighbors.add(copied[n.val]);
            }
        }
        return copied[node.val];
    }

    // Method 2: DFS
    public Node cloneGraphDFS(Node node) {
        Node[] copied = new Node[101]; // old node -> copied node
        return DFSCopy(node, copied);
    }

    private Node DFSCopy(Node cur, Node[] copied) {
        if (cur == null) {
            return null;
        }

        if (copied[cur.val] == null) {
            copied[cur.val] = new Node(cur.val);
        }

        for (Node n : cur.neighbors) {
            if (copied[n.val] != null) {
                copied[cur.val].neighbors.add(copied[n.val]);
            } else {
                copied[cur.val].neighbors.add(DFSCopy(n, copied));
            }
        }

        return copied[cur.val];
    }
}
