package Easy;

import Easy.BalancedBinaryTree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q !=null) || (p != null && q == null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2021(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null ^ q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
