package medium;

public class CoinChange {

    // dp
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length < 1 || amount < 1)
            return 0;

        int[] dp = new int[amount + 1]; // number of coins needed to get i dollars
        dp[0] = 0;
        for(int i = 1; i < amount + 1; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){      // for each kind of coins
                if(i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }



    // slower
    /*
    private static int coinChange(int[] coins, int amount) {
    		if (coins.length < 1 || coins == null || amount < 0)	return -1;
        
        return topDown(coins, amount);        
    }
    
    static private int topDown(int[] coins, int amount){    	   
        int dp[] = new int[amount + 1];
        // dp[i] : smallest number for amount i
        
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] != Integer.MAX_VALUE && i + coins[j] <= amount && dp[i]!= Integer.MAX_VALUE)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];       	
    }*/

}
