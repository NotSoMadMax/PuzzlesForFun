package medium;

import java.util.*;

public class BinaryTreePreorderTraversal {
    private List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        while (!s.empty() || cur != null){
            if(cur != null)
            {
                res.add(cur.val);
                s.push(cur);
                cur = cur.left;
            }
            else    // meet left end
            {
                cur = s.pop();
                cur = cur.right;
            }
        }

        return res;
    }
}
