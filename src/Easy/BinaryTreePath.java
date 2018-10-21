package Easy;

import java.util.*;

public class BinaryTreePath {
    private List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<String> res = new ArrayList<>();
        dfs(res, root.val + "", root);

        return res;
    }

    private static void dfs(List<String> res, String ans,TreeNode cur){
        if(cur.left == null && cur.right == null)
        {
            res.add(ans);
            return;
        }

        if(cur.left != null)
            dfs(res, ans + "->" + String.valueOf(cur.left.val), cur.left);

        if(cur.right != null)
            dfs(res, ans + "->" + String.valueOf(cur.right.val), cur.right);

    }
}
