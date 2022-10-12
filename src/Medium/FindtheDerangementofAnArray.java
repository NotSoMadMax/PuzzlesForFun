package medium;

public class FindtheDerangementofAnArray {
    public int findDerangement(int n) {
        if(n < 2)
            return 0;

        /*
        long[] dp = new long[n+1];
        dp[1] = 0;
        dp[2] = 1;
        */

        long i_2 = 0;
        long i_1 = 1;

        for(int i = 3; i <= n; i++){
            long temp = (i - 1) * (i_2 + i_1);
            i_2 = i_1;
            i_1 = temp % 1000000007;
        }

        return (int)i_1;
    }
}
