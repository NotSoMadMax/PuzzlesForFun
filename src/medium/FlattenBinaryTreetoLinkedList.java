package medium;

import java.util.ArrayList;
import java.util.List;

class FlattenBinaryTreetoLinkedList {
    private void flatten(TreeNode root) {
        if (root == null)
            return;

        List<TreeNode> result = new ArrayList<TreeNode>();
        preorder_travel(root, result);
        int len = result.size();
        for (int i = 0; i < len-1; i++){
            result.get(i).left = null;
            result.get(i).right = result.get(i + 1);
        }

        return;
    }

    private static void preorder_travel(TreeNode root, List<TreeNode> result){
        if (root == null)
            return;

        result.add(root);
        preorder_travel(root.left, result);
        preorder_travel(root.right, result);
    }
}
