package medium;

import java.util.*;

public class CircularArrayLoop {
    // Method 1
    private boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length < 1)
            return false;

        int len = nums.length;
        Map<Integer, Integer> m = new HashMap<>();  // cur -> next
        boolean[] visited = new boolean[len];

        for(int i = 0; i < len; i++){
            if(visited[i])
                continue;

            int cur = i;
            while (true)
            {
                visited[cur] = true;
                int next = (cur + nums[cur])% len;
                while (next < 0)
                    next += len;

                if(cur == next) // single number loop
                    break;
                if(nums[cur] * nums[next] < 0)  // change direction
                    break;
                if(m.containsKey(next))
                    return true;

                m.put(cur, next);
                cur = next;
            }
        }

        return false;
    }

    // Method 2: 2 pointers, O(n) space, slow
    private boolean circularArrayLoop1(int[] nums) {
        if(nums == null || nums.length < 1)
            return false;

        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if (nums[i] == 0)
                continue;

            int slow = i, fast = nextIndex(i, nums);
            while (nums[slow] * nums[fast] > 0) {

                int next_fast = nextIndex(fast, nums);

                if (nums[fast] * nums[next_fast] < 0)
                    break;
                if (slow == nextIndex(slow, nums))   // one number loop
                    break;

                if (slow == fast)
                    return true;

                slow = nextIndex(slow, nums);
                fast = nextIndex(next_fast, nums);
            }

            int cur = i, prev = nums[i];
            while (nums[cur] * prev > 0){
                int next = nextIndex(cur, nums);
                nums[cur] = 0;
                cur = next;
            }
        }
            return false;
    }

    private int nextIndex(int cur, int[] nums){
        int len = nums.length;
        int next = (cur + nums[cur])%len;
        while (next < 0)
            next += len;
        return next;
    }
}
