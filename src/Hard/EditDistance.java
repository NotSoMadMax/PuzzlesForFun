package Hard;

public class EditDistance {
    private int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null)
            return 0;
        if(word1 == null)
            return word2.length();
        if(word2 == null)
            return word1.length();

        // initialize dp array
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];

        // when one string is empty
        for(int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for(int j = 0; j <= len2; j++)
            dp[0][j] = j;

        // dp[i][j] = min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]}
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
