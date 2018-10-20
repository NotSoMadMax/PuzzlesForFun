package medium;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> s;

    public BinarySearchTreeIterator(TreeNode root) {
        s = new Stack<>();

        while (root != null){
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = s.pop();

        if(cur.right != null){
            TreeNode rightcur = cur.right;

            while (rightcur != null){
                s.push(rightcur);
                rightcur = rightcur.left;
            }
        }

        return cur.val;
    }
}
