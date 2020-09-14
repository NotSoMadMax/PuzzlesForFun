package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return Collections.emptyList();
        }

        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        int leftSize = 1;
        int rightSize = N - 2; // deduct the root as well
        while (rightSize > 0) {
            List<TreeNode> possibleLeftTrees = allPossibleFBT(leftSize);
            List<TreeNode> possibleRightTrees = allPossibleFBT(rightSize);
            leftSize += 2;
            rightSize -= 2;

            for (TreeNode possibleLeftTree : possibleLeftTrees) {
                for (TreeNode possibleRightTree : possibleRightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = possibleLeftTree;
                    root.right = possibleRightTree;
                    res.add(root);
                }
            }
        }

        return res;
    }

}
