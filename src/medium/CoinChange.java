package medium;

public class CoinChange {
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
    }
    
    /*
	    if (amount < 0) return - 1;
	    if (dp[amount] != INT_MAX) return dp[amount];
	    for (int i = 0; i < coins.size(); ++i) {
	        int tmp = coinChangeDFS(coins, amount - coins[i], dp);
	        if (tmp >= 0) dp[amount] = min(dp[amount], tmp + 1);
	    }
	    
	    return dp[amount] == INT_MAX ? -1 : dp[amount];
    */
    static void main(String[] args){
    		int[] coin = {1,2,5,10};
    		System.out.println(coinChange(coin, 21));;
    }
    
}
