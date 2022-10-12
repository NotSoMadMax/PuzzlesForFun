package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> sequence1 = new LinkedList<>();
        inOrderTraversal(root1, sequence1);
        Queue<Integer> sequence2 = new LinkedList<>();
        inOrderTraversal(root2, sequence2);

        List<Integer> res = new ArrayList<>();
        while (!sequence1.isEmpty() && !sequence2.isEmpty()) {
            if (sequence1.peek() <= sequence2.peek()) {
                res.add(sequence1.poll());
            } else {
                res.add(sequence2.poll());
            }
        }

        res.addAll(sequence1);
        res.addAll(sequence2);

        return res;
    }

    private void inOrderTraversal(TreeNode cur, Queue<Integer> sequence) {
        if (cur == null) {
            return;
        }

        inOrderTraversal(cur.left, sequence);
        sequence.add(cur.val);
        inOrderTraversal(cur.right, sequence);
    }
}
