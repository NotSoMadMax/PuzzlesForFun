package Easy;

public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return search(root, false);
    }

    private int search(TreeNode cur, boolean isLeft) {
        if(cur == null)
            return 0;

        if(isLeaf(cur)) {
            if (isLeft)
                return cur.val;
            else
                return 0;
        }

        int leftSum = search(cur.left, true);
        int rightSum = search(cur.right, false);

        return leftSum + rightSum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
