package medium;

public class CoinChangeII {

    // dp, O(n) space
    private static int change(int amount, int[] coins) {
        if (amount < 1)
            return 1;

        if (coins == null || coins.length < 1)
            return 0;

        int[] dp = new int[amount + 1];     // number of ways to get amount j
        dp[0] = 1;

        for(int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    // 2d dp, slow
    /*
    public int change(int amount, int[] coins) {
        if(amount < 1)
            return 1;

        if(coins == null || coins.length < 1)
            return 0;

        // use first i coins to get amount j
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= coins.length; i++){
            dp[i][0] = 1;   // use i coins to get amount 0
            for(int j = 1; j <= amount; j++){
                if (j >= coins[i - 1])
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];   // don't use the ith coin, or use one coin i
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[coins.length][amount];
    }
    */
}
