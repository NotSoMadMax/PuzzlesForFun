package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        Arrays.stream(to_delete).forEach(toDelete::add);
        List<TreeNode> res = new ArrayList<>();

        DFSDelete(root, res, true, toDelete);

        return res;
    }

    private TreeNode DFSDelete(TreeNode cur, List<TreeNode> res, boolean isRoot, Set<Integer> toDelete) {
        if (cur == null) {
            return null;
        }

        boolean deleteCur = toDelete.contains(cur.val);
        if (isRoot && !deleteCur) {
            res.add(cur);
        }

        cur.left = DFSDelete(cur.left, res, deleteCur, toDelete);   // child will be new root if current node is deleted
        cur.right = DFSDelete(cur.right, res, deleteCur, toDelete);

        return deleteCur ? null : cur;
    }
}
