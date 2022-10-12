package medium;

import java.util.*;

class FindDuplicateSubtrees {
    private List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null)
        	return Collections.emptyList();
        
        List<TreeNode> res = new ArrayList<>();
    	Map<String, Integer> count = new HashMap<>();
    	search(root, count, res);
    	
    	return res;
    }
    
    private String search(TreeNode cur, Map<String, Integer> count, List<TreeNode> res){
    	if(cur == null)
    		return "";
    	
    	String code = cur.val + "," + search(cur.left, count, res) + "," + search(cur.right, count, res);
    	count.put(code, count.getOrDefault(code, 0) + 1);
    	
    	if(count.get(code) == 2)
    		res.add(cur); 
    	return code;
    }

    /*
    2020
     */

	/* Method 1, binary search
		- guess the number is mid each time
		- count and see how many number are smaller than mid
		- adjust boundary based on count
	 */
	public int findDuplicate202001(int[] nums) {
		if (nums == null || nums.length < 1) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int n : nums) {
				if (n <= mid) {
					count++;
				}
			}
			if (count <= mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}

	/* Method 2 Two pointers */
	// Equivalent to find cycle in linked list
	public int findDuplicate202002(int[] nums) {
		if (nums == null || nums.length < 1) {
			return -1;
		}

		int slow = 0;
		int fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast) {	// they met in the cycle
				break;
			}
		}

		/* let fast starts from the begining
		 when they met again, it will be at the point where the node is pointed by two nodes (where the cycle is formed)
		 */
		fast = 0;
		while (true) {
			fast = nums[fast];
			slow = nums[slow];
			if (fast == slow) {
				break;
			}
		}

		return fast;
	}
}
