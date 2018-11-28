package medium;

public class PalindromicSubstrings {

    // Method 3: expand from center, 52.9%, 13ms
    private static int countSubstrings3(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int len = s.length();
        int res = 0;
        for(int i = 0; i < len; i++)
        {
            int l = i, r = i;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r))
            {
                res++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r))
            {
                res++;
                l--;
                r++;
            }
        }

        return res;
    }


    // Method 2: Brutal Force with memorization, 7.97%, 192ms
    private static int countSubstrings2(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int len = s.length();
        int[][] memo = new int[len][len + 1];   // 0: not calculated yet. 1: palin. -1: not palin
        int res = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j <= len; j++)
            {
                if(memo[i][j] == -1)
                    continue;
                else if(memo[i][j] == 1)
                    res++;
                else {
                    if(isPanlin(s.substring(i, j)))
                    {
                        memo[i][j] = 1;
                        res++;
                    }else
                        memo[i][j] = -1;
                }
            }
        }
        return res;
    }


    // Method 1: Brutal Force, 5%, 259ms
    private static int countSubstrings1(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int len = s.length();
        int res = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j <= len; j++)
            {
                if(isPanlin(s.substring(i, j)))
                    res++;
            }
        }
        return res;
    }

    private static boolean isPanlin(String s){
        int l = 0, r = s.length() - 1;
        while (l < r)
        {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args){
        String a = "abc";
        System.out.println(countSubstrings1(a));
    }
}
