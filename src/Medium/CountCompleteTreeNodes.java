package medium;

public class CountCompleteTreeNodes {

    // 98%, but why ???
    public int countNodes_fast(TreeNode root) {
        if(root==null) return 0;

        if (root.val != Integer.MIN_VALUE) {
            root.val = Integer.MIN_VALUE;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        else
            return 0;
    }


    // 86%
    public int countNodes2(TreeNode root){
        if(root == null)
            return 0;

        TreeNode l = root.left, r = root.right;
        int num = 2;

        while (l != null && r != null){
            l = l.left;
            r = r.right;
            num = num << 1;
        }

        if(l == r)
            return num - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }


    // 70%
    public int countNodes(TreeNode root) {
            if (root == null)
                return 0;

            int left_hight = 1, right_hight = 1;
            TreeNode l = root.left, r = root.right;

            while (l != null){  // left height
                left_hight++;
                l = l.left;
            }

            while (r != null){  // right height
                right_hight++;
                r = r.right;
            }

            if(left_hight == right_hight)   // if is a perfect binary tree
                return (1<<left_hight) - 1; //67ms
                // return (int)Math.pow(2, left_hight) - 1; // 130ms
            else
                return countNodes(root.left) + countNodes(root.right) + 1;
    }


    // brutal force: time limit exceeds
    public int countNodes_brutal(TreeNode root){
        if(root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
