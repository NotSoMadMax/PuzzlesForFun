package Hard;

import java.util.*;

public class TrappingRainWater {

    // Method 2: stack, 42%
    private int trap2(int[] height) {
        if(height == null || height.length < 1)
            return 0;

        Stack<Integer> s = new Stack<>();   // store the decreasing sequence
        int res = 0;
        int i = 0;
        while (i < height.length)
        {
            while (!s.isEmpty() && height[i] > height[s.peek()]){
                int bottom = s.pop();
                if(s.isEmpty()) // only one side is bounded, cannot trap water
                    break;

                int h_diff = Math.min(height[s.peek()], height[i]) - height[bottom];
                res += h_diff * (i - s.peek() - 1);
            }

            s.push(i++);
        }

        return res;
    }


    // Method 1: DP, 100%
    private int trap(int[] height) {
        if(height == null || height.length < 1)
            return 0;

        int len = height.length;
        int[] dp = new int[len];
        int left_max = 0;
        for(int i = 0; i < len; i++){
            left_max = Math.max(left_max, height[i]);
            dp[i] = left_max;
        }

        int res = 0;
        int right_max = height[len - 1];
        for(int i = len - 1; i >= 0; i--){
            right_max = Math.max(height[i], right_max);
            int top = Math.min(right_max, dp[i]);
            if(top > height[i])
                res += top - height[i];
        }

        return res;
    }
}
