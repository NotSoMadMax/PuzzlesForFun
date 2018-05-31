package Easy;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class SymmetricTree {

    private static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        TreeNode temp = root;

        return helper(root, temp);
    }

    private static boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;

        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;

        if(root1.val != root2.val)
            return false;

        if(helper(root1.left, root2.right) && helper(root1.right, root2.left))
            return true;
        else
            return false;
    }

}
