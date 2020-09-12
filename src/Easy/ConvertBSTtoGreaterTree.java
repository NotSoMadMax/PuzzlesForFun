package Easy;

public class ConvertBSTtoGreaterTree {
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

    private int rightSum = 0;

    public TreeNode convertBST(TreeNode root) {
        DFSGetSum(root);
        return root;
    }

    // Right-child-first DFS to get sum of greater numbers
    private void DFSGetSum(TreeNode cur) {
        if (cur == null) {
            return;
        }

        if (cur.right != null) {
            DFSGetSum(cur.right);
        }

        rightSum += cur.val;
        cur.val = rightSum;

        if (cur.left != null) {
            DFSGetSum(cur.left);
        }
    }
}
