package Hard;

import java.util.Stack;

public class LongestValidParentheses {

    // Method 2: dynamic programming, 98%
    private int longestValidParentheses_DP(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int[] dp = new int[s.length()]; // length of sequence ends at i
        int res = 0;

        for(int i = 1; i < s.length(); i++){
            // if(s.charAt(i) == '(')   // valid parentheses cannot end with '('
            if(s.charAt(i) == ')')
            {
                if(s.charAt(i - 1) == '(')
                {
                    if(i >= 2)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                }
                else if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')   // i - 1 is ')', and one char before the current sequence
                {
                    if(i - dp[i - 1] >= 2)
                        dp[i] = dp[i - 1] + dp[i - dp[i-1] - 2] + 2;
                    else
                        dp[i] = dp[i - 1] + 2;
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }



    // Method 1: stack and start, 34%
    private int longestValidParentheses(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int res = 0, start = 0;
        Stack<Integer> leftp = new Stack<>();   // index of left parentheses

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                leftp.push(i);
            else    // is ')'
            {
                if(leftp.isEmpty()) // meet a ')' and stack is empty, start a new sequence
                    start = i + 1;
                else    // has '(' to match with current ')'
                {
                    leftp.pop();

                    if(leftp.isEmpty())
                        res = Math.max(res, i - start + 1);
                    else
                        res = Math.max(res, i - leftp.peek());
                }
            }
        }

        return res;
    }
}
