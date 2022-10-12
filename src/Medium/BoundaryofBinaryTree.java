package medium;

import java.util.*;

public class BoundaryofBinaryTree {
    private List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        res.add(root.val);

        TreeNode cur = root.left;
        // Add left boundaries
        if(cur != null){
            while(cur.left != null || cur.right != null){
                res.add(cur.val);
                if(cur.left != null)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
        }

        cur = root;
        // Add leaves
        addLeaves(cur.left, res);
        addLeaves(cur.right, res);

        cur = root.right;
        // Add right boundaries
        if(cur != null){
            Stack<Integer> temp = new Stack<>();
            while (cur.left != null || cur.right != null){
                temp.add(cur.val);
                if(cur.right != null)
                    cur = cur.right;
                else
                    cur = cur.left;
            }

            while (!temp.isEmpty())
                res.add(temp.pop());
        }

        return res;
    }

    private void addLeaves(TreeNode cur, List<Integer> res){
        if(cur == null)
            return;

        if(cur.left == null && cur.right == null){
            res.add(cur.val);
            return;
        }

        addLeaves(cur.left, res);
        addLeaves(cur.right, res);
    }
}












