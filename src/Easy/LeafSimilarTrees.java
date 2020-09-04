package Easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        findLeafDFS(leaves1, root1);
        findLeafDFS(leaves2, root2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }

        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void findLeafDFS(List<Integer> leaves, TreeNode cur) {
        if (cur == null) {
            return;
        }

        if (cur.left == null && cur.right == null) {
            leaves.add(cur.val);
        }

        findLeafDFS(leaves, cur.left);
        findLeafDFS(leaves, cur.right);
    }
}
