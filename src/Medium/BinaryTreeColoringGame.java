package medium;

public class BinaryTreeColoringGame {
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

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] maxSubSize = new int[1];
        int[] subTreeSizesX = new int[1]; // sub Tree size of node x

        findSubTreeSize(root, maxSubSize, subTreeSizesX, x);

        maxSubSize[0] = Math.max(maxSubSize[0], n - subTreeSizesX[0]); // block parent

        return maxSubSize[0] > n/2;
    }

    // DFS to get subTree size
    private int findSubTreeSize(TreeNode cur, int[] maxSize, int[] subTreeSizesX, int x) {
        if (cur == null) {
            return 0;
        }

        int leftSize = findSubTreeSize(cur.left, maxSize, subTreeSizesX, x);
        int rightSize = findSubTreeSize(cur.right, maxSize, subTreeSizesX, x);
        int curSize = 1 + leftSize + rightSize;

        if (cur.val == x) {
            subTreeSizesX[0] = curSize;
            maxSize[0] = Math.max(leftSize, rightSize);    // either block the left or right subtree
        }

        return curSize;
    }
}
