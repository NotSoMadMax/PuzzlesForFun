package Easy;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        
        return leftdepth>rightdepth?(leftdepth+1):(rightdepth+1);
    }
}
