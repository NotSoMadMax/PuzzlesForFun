package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.add(root.val);
        DFSSearchMax(root, 0, res);
        return res;
    }

    // Method 1: DFS
    private void DFSSearchMax(TreeNode cur, int curDepth, List<Integer> maxValues) {
        if (curDepth > maxValues.size()) {
            maxValues.add(cur.val);
        } else {
            maxValues.set(curDepth, Math.max(maxValues.get(curDepth), cur.val));
        }
        if (cur.left != null) {
            DFSSearchMax(cur.left, curDepth + 1, maxValues);
        }
        if (cur.right != null) {
            DFSSearchMax(cur.right, curDepth + 1, maxValues);
        }
    }
}
