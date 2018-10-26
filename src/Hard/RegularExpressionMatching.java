package Hard;

public class RegularExpressionMatching {

    // Method 1: backtracing, 16%
    private boolean isMatch(String s, String p) {
        if(p.length() < 1)
            return s.length()<1?true:false;

        // p.length = 1
        if(p.length() == 1){
            if(s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
                return true;
            else
                return false;
        }

        // p[1] is not *
        if(p.charAt(1) != '*'){
            if(s.length() < 1)
                return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }


        // p[1] is *, it can match 0,1,2... times
        while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            if (isMatch(s, p.substring(2))) // don't use it
                return true;
            s = s.substring(1);     // use it to match one more time
        }

        return isMatch(s, p.substring(2));  // done with current char in p
    }

    // Method 2: DP, 88%
    private boolean isMatchDP(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;    // when both are empty

        // initialize first row and col
        for(int i = 1; i <= s.length(); i++)    // empty p
            dp[i][0] = false;

        for(int j = 2; j <= p.length(); j++)    // empty s
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];

        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = 1; j <= p.length(); j++)
            {
                if(p.charAt(j-1) == '*')
                    // don't use it, or use it once
                    dp[i][j] = dp[i][j-2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
            }
        }

        return dp[s.length()][p.length()];
    }
}

