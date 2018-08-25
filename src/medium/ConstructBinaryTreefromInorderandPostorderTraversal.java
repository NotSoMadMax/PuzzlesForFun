package medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)
        	return null;                		
		        
		return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
	
	
	// idea: find corresponding (left)(root)(right) portion in each sequence
	private static TreeNode helper(int[] inorder, int[] postorder, int ino_l, int ino_r, int pos_l, int pos_r){
		if (pos_l > pos_r)
			return null;
		
		TreeNode cur_root = new TreeNode(postorder[pos_r]);
		
		for (int i = ino_l; i <= ino_r; i++){
			if(inorder[i] == postorder[pos_r]){
				cur_root.left = helper(inorder, postorder, ino_l, i - 1, pos_l, pos_l + (i - ino_l) - 1);
				cur_root.right = helper(inorder, postorder, i + 1, ino_r, pos_l + (i - ino_l), pos_r - 1);
				break;
			}
		}		
		
		return cur_root;
	}
	
	// method 2, faster, the post_left is not needed
	@SuppressWarnings("unused")
	private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
		if (postStart < 0 || inStart < inEnd)
			return null;
		
		//The last element in postorder is the root.
		TreeNode root = new TreeNode(postorder[postStart]);
		
		//find the index of the root from inorder. Iterating from the end.
		int rIndex = inStart;
		for (int i = inStart; i >= inEnd; i--) {
			if (inorder[i] == postorder[postStart]) {
				rIndex = i;
				break;
			}
		}
		
		//build right and left subtrees. Again, scanning from the end to find the sections.
		root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
		root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
		return root;
	}
}
