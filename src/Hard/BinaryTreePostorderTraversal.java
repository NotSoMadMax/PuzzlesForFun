package Hard;

import java.util.*;

public class BinaryTreePostorderTraversal {

    // Method 2: one stack
    private List<Integer> postorderTraversalOne(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode pre = null;

        while (!s.empty()){
            TreeNode cur = s.peek();

            if(pre == null || cur == pre.left || cur == pre.right){ // reach next level of pre
                if(cur.left != null)
                    s.push(cur.left);
                else if(cur.right != null)
                    s.push(cur.right);
                else    // reach bottom
                {
                    res.add(cur.val);
                    s.pop();
                }
            }
            else if(cur.left == pre){   // already visited left
                if(cur.right != null)
                    s.push(cur.right);
                else
                {
                    res.add(cur.val);
                    s.pop();
                }

            }
            else if(cur.right == pre){      // already visited left and right
                res.add(cur.val);
                s.pop();
            }

            pre = cur;
        }


        return res;
    }

    // Method 2: two stack
    private List<Integer> postorderTraversalTwo(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.empty()){
            TreeNode cur = s1.pop();
            s2.push(cur);

            if(cur.left != null)
                s1.push(cur.left);

            if(cur.right != null)
                s1.push(cur.right);
        }

        while (!s2.empty())
            res.add(s2.pop().val);

        return res;
    }
}
