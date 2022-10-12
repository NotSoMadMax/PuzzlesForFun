package medium;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = DFSSearch(root);

        return Math.max(res[0], res[1]);
    }

    /*
    res[0]: max value if doesn't include cur
    res[1]: max value if inlude cur
     */
    private int[] DFSSearch(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }

        int[] left = DFSSearch(cur.left);
        int[] right = DFSSearch(cur.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // Doesn't rub cur
        res[1] = cur.val + left[0] + right[0];

        return res;
    }
}
