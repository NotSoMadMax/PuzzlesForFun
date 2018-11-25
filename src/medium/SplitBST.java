package medium;

public class SplitBST {
    private TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];

        if(root == null)
        {
            return res;
        }
        else if(root.val <= V)
        {
            TreeNode[] cur_res = splitBST(root.right, V);
            root.right = cur_res[0];
            res[0] = root;
            res[1] = cur_res[1];
        }
        else if(root.val > V)
        {
            TreeNode[] cur_res = splitBST(root.left, V);
            root.left = cur_res[1];
            res[1] = root;
            res[0] = cur_res[0];
        }

        return res;
    }
}
