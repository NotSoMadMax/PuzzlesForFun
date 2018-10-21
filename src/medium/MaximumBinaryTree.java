package medium;

public class MaximumBinaryTree {
    private TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null)
            return null;

        return construct(nums, 0, nums.length - 1);
    }


    private TreeNode construct(int[] nums, int l, int r){
        if(l > r)
            return null;

        if(l == r)
            return new TreeNode(nums[l]);

        int max_index = l;
        for (int i = l; i <= r; i++){
            if(nums[i] > nums[max_index])
                max_index = i;
        }

        TreeNode cur = new TreeNode(nums[max_index]);
        cur.left = construct(nums, l, max_index - 1);
        cur.right = construct(nums, max_index + 1, r);

        return cur;
    }
}
