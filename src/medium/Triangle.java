package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Triangle {

    // dp, top down, O(n) space
    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() < 1 || triangle.get(0).size() < 1)
            return 0;

        int[] dp = new int[triangle.size()];    // only keep current level
        int last;       // to keep last level value (i - 1, j - 1)

        dp[0] = 0;
        for(int i = 1; i < triangle.size(); i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < triangle.size(); i++){
            last = Integer.MAX_VALUE; // first of each row doesn't have left parent (i - 1, j - 1)
            for (int j = 0; j <= i; j++){
                int temp = dp[j];   // i-1, j
                dp[j] = triangle.get(i).get(j) + Math.min(last, temp);  // (i - 1, j - 1) & (i-1, j)
                last = temp;
            }
        }

        int res = dp[0];
        for(int i:dp){
            res = Math.min(i, res);
        }

        return res;
    }


    // Method 1: dp， bottom up, O(nk) space
    /*
    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
        	return 0;
        
        int len = triangle.size();
        int[][] results = new int[len][len];
        for (int i = 0; i < len; i++){
        	results[len-1][i] = triangle.get(len-1).get(i);
        }
        
        for (int i = len - 2; i >= 0; i--){     // level
        	for (int j = 0; j < i + 1; j++){    // position
        		results[i][j] = triangle.get(i).get(j) + Math.min(results[i+1][j], results[i+1][j+1]);
        	}
        }
        
        return results[0][0];
    }*/



    /*  // Method 2: backtracing, time limit exceeds
    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() < 1)
            return 0;

        return helper(triangle, triangle.get(0).get(0), 0, 0);
    }

    private static int helper(List<List<Integer>> triangle, int cur_sum, int pos, int depth){
        if(depth == triangle.size() - 1){
            return cur_sum;
        }

        int left = helper(triangle, cur_sum + triangle.get(depth + 1).get(pos), pos, depth + 1);
        int right = helper(triangle, cur_sum + triangle.get(depth + 1).get(pos + 1), pos + 1, depth + 1);

        return Math.min(left, right);
    }
    */
}




