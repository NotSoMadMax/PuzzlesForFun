package Hard;

import java.util.*;

public class PalindromePairs {
    private List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length < 1)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            m.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for(int i = 0; i < words.length; i++)
        {
            int len = words[i].length();
            for(int j = 0; j <= len; j++)
            {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j, len);

                if(isPanlindrome(left) && m.containsKey(right) && m.get(right) != i && len > len - j)   // if the palindrome of the whole words[i] exists, it will duplicate
                {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(m.get(right));
                    ans.add(i);
                    res.add(ans);
                }
                if(isPanlindrome(right) && m.containsKey(left) && m.get(left) != i)
                {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(m.get(left));
                    res.add(ans);
                }
            }
        }

        return res;
    }


    private static boolean isPanlindrome(String s){
        if(s == null || s.isEmpty())
            return true;

        int left = 0, right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args){
        String s = "abc";
        String a = s.substring(3, 3);
        System.out.println(a.length());
    }

}
