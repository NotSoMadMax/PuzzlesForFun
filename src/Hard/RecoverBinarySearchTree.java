package Hard;

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class RecoverBinarySearchTree {
    TreeNode pre, n1, n2;


    private void recoverTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;

        // TreeNode pre = null, n1 = null, n2 = null;
        inorder(root);

        if(n1 != null && n2 != null){
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }

        return;
    }

    // Method 1: recursive in-order traversal
    private void inorder(TreeNode cur){
        if(cur == null)
            return;

        if(cur.left != null)    // left tree
            inorder(cur.left);

        if(pre != null && cur.val < pre.val) {   // reversion found
            if (n1 == null) {  // first reversion
                n1 = pre;
                n2 = cur;
            }
            else
                n2 = cur;
        }
        pre = cur;

        if(cur.right != null)   // right tree
            inorder(cur.right);

        return;
    }

    // Method 2: iterative, not working

    private static void iterRecoverTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;

        Stack<TreeNode> s = new Stack<>();

        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode n1 = null, n2 = null;

        while (!s.empty() || cur != null){
            if(cur != null){
                s.add(cur);
                cur = cur.left;
            }
            else {  // cur is null, pop and add to result
                cur = s.pop();

                if(pre != null && cur.val < pre.val) {   // reversion found
                    if (n1 == null) {  // first reversion
                        n1 = pre;
                        n2 = cur;
                    }
                    else
                        n2 = cur;
                }

                pre = cur;
                cur = cur.right;
            }
        }

        if(n1 != null && n2 != null){
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }

        return;
    }

}
