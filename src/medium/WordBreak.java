package medium;

import java.util.*;

public class WordBreak {

    // Method 4: DP, 80%
    private boolean wordBreak4(String s, List<String> wordDict) {
        if(s == null || s.isEmpty())
            return true;
        if(wordDict == null || wordDict.size() < 1)
            return false;

        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;   // empty string, true

        for(int i = 1; i <= s.length(); i++)     // the sub problem
        {
            for(int j = 0; j < i; j++)
            {
                if(dp[j] && dict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    // Method 3: BFS, 77.8%
    private boolean wordBreak3(String s, List<String> wordDict) {
        if(s == null || s.isEmpty())
            return true;
        if(wordDict == null || wordDict.size() < 1)
            return false;

        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];  // memo
        q.add(0);

        while (!q.isEmpty())
        {
            int start = q.poll();
            if(!visited[start]){
                for(int i = start + 1; i <= s.length(); i++){
                    if(dict.contains(s.substring(start, i))){
                        q.add(i);

                        if(i == s.length())
                            return true;
                    }
                }
            }
            visited[start] = true;
        }

        return false;
    }


    // Method 2: Brutal Force with Memorization. 87%!!!
    private boolean wordBreak2(String s, List<String> wordDict) {
        if(s == null || s.isEmpty())
            return true;
        if(wordDict == null || wordDict.size() < 1)
            return false;

        Boolean[] memo = new Boolean[s.length()];
        return search(s, new HashSet<>(wordDict), 0, memo);
    }

    private static boolean search(String s, HashSet<String> dict, int start, Boolean[] memo){
        if(start == s.length())
            return true;

        if(memo[start] != null)
            return memo[start].booleanValue();

        for(int i = start + 1; i <= s.length(); i++){
            if(dict.contains(s.substring(start, i)) && search(s, dict, i, memo)){
                memo[start] = new Boolean(true);
                return true;
            }
        }

        memo[start] = new Boolean(false);
        return false;
    }


    // Method 1: Brutal Force, Time Limit Exceeds
    private boolean wordBreak1(String s, List<String> wordDict) {
        if(s == null || s.isEmpty())
            return true;
        if(wordDict == null || wordDict.size() < 1)
            return false;

        return search(s, new HashSet<>(wordDict), 0);
    }

    private static boolean search(String s, HashSet<String> dict, int start){
        if(start == s.length())
            return true;

        for(int i = start + 1; i <= s.length(); i++){
            if(dict.contains(s.substring(start, i)) && search(s, dict, i))
                return true;
        }

        return false;
    }

    public static void main(String[] args){

    }
}
