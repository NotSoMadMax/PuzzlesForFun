package medium;

import java.util.*;

class BinaryTreeVerticalOrderTraversal {

    private List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        TreeMap<Integer, List<Integer>> m = new TreeMap<>();

        Queue<TreeNode> q = new LinkedList<>();    // {TreeNode}
        Queue<Integer> pos = new LinkedList<>();
        q.add(root);
        pos.add(0);

        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            int cur_pos = pos.poll();
            m.putIfAbsent(cur_pos, new ArrayList<>());
            m.get(cur_pos).add(cur.val);

            if(cur.left != null){
                q.add(cur.left);
                pos.add(cur_pos - 1);
            }
            if(cur.right != null){
                q.add(cur.right);
                pos.add(cur_pos + 1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l:m.values())
            res.add(l);

        return res;
    }


}
