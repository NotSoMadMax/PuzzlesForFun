package medium;

public class UniqueBinarySearchTrees {
	
	// iteratively dp
    private static int numTrees(int n) {
        if (n < 1)
        		return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++){
        		for (int j = 0; j < i; j++){
        			dp[i] += dp[j]*dp[i - j - 1];
        		}
        }
        
        return dp[n];
    }
    
}
