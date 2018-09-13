package medium;

class PerfectSquares {
    private int numSquares(int n) {
        if(n < 1)
            return 0;

        while (n%4 == 0)
            n /= 4;

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;

        for(int i = 0; i <= n; i++){
            for(int j=1; i + j*j <= n; j++){
                dp[i + j*j] = Math.min(dp[i+j*j], dp[i] + 1);
            }
        }

        return dp[n];
    }
}
