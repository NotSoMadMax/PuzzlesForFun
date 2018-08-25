package medium;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length <= 0 || inorder.length <= 0)
        	return null;
        
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    
    // idea: find corresponding (left)(root)(right)
    private static TreeNode helper(int[] preorder, int[] inorder, int pre_l, int pre_r, int ino_l, int ino_r){
    	if (pre_l > pre_r)
    		return null;
    	
    	TreeNode cur_root = new TreeNode(preorder[pre_l]);	// create root
    	
    	for(int i = ino_l; i <= ino_r; i++){
    		if (inorder[i] == preorder[pre_l]){		// find index of root in inorder[]
    			cur_root.left = helper(preorder, inorder, pre_l + 1, pre_l + (i - ino_l), ino_l, i - 1);	// (i - ino_l): length of left tree
    			cur_root.right = helper(preorder, inorder, pre_l + (i - ino_l) + 1, pre_r, i + 1, ino_r);
    			break;
    		}
    	}
    	
    	return cur_root;
    }
}
