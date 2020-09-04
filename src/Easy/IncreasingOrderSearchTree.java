package Easy;

public class IncreasingOrderSearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        return inOrderDFS(root, null);
    }

    private TreeNode inOrderDFS(TreeNode cur, TreeNode prev) {
        if (cur == null) {
            return prev;
        }

        TreeNode root = inOrderDFS(cur.left, cur);  // get the left-most node as root
        cur.left = null;
        cur.right = inOrderDFS(cur.right, prev);    // get the left-most from right tree

        return root;
    }
}
