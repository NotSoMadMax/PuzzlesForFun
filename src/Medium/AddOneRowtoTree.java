package medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        while (queue != null) {
            int levelSize = queue.size();
            for (int i = 0 ; i < levelSize; i++) {
                TreeNode cur = queue.poll();

                if (depth == d - 1) {
                    TreeNode originalLeft = cur.left;
                    TreeNode originalRight = cur.right;
                    cur.left = new TreeNode(v);
                    cur.right = new TreeNode(v);
                    cur.left.left = originalLeft;
                    cur.right.right = originalRight;
                } else {
                    if (cur.left !=null) {
                        queue.add(cur.left);
                    }
                    if (cur.right !=null) {
                        queue.add(cur.right);
                    }
                }
            }

            if (depth == d - 1) {
                break;
            }
            depth++;
        }

        return root;
    }
}
