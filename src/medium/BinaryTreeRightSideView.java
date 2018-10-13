package medium;

import java.util.*;

public class BinaryTreeRightSideView {
    private List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()){
            int level_size = q.size();      // number of nodes of current level

            for(int i = 0; i < level_size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);

                if(i == level_size - 1) // add the last node of this level to result
                    res.add(cur.val);
            }

        }

        return res;
    }
}
