package medium;

class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        if(n < 1)
            return 0;

        int[][] dp = new int[n+1][n+1]; // guess cost for number in range(i, j)

        for(int i = 2; i <=n; i++){
            for(int j = i + 1; j <= n; j++){

                int local_min = Integer.MAX_VALUE;
                for(int guess = i + 1; guess < j; guess++){
                    int cost = 0;

                        cost = Math.max(dp[i][guess-1], dp[guess+1][j]) + guess;

                    if(cost < local_min)
                        local_min = cost;
                }

                if(i + 1 == j)
                    dp[i][j] = i;
                else
                    dp[i][j] = local_min;
            }
        }

        return dp[n][n];
    }


    // Method 1: recursion, exceeds time limit
    // helper(1, n)
    private int helper(int start, int end){
        if(start >= end)
            return 0;
        if(end - start == 1)
            return start;
        if(end - start == 2)
            return start + 1;

        int local_min = Integer.MAX_VALUE;
        for(int guess = start; guess <= end; guess++){
            int cost = Math.max(helper(start, guess - 1), helper(guess + 1, end)) + guess;
            if(cost < local_min)
                local_min = cost;
        }

        return local_min;
    }


}
