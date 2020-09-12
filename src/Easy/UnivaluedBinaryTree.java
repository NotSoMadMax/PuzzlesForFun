package Easy;

public class UnivaluedBinaryTree {

    public class TreeNode {
        int val;
        ConvertBSTtoGreaterTree.TreeNode left;
        ConvertBSTtoGreaterTree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, ConvertBSTtoGreaterTree.TreeNode left, ConvertBSTtoGreaterTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }


        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
