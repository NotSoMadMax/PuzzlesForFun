package medium;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromefromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // count of each alphabet up to position [i]
        // padding an 1 on the left to avoid dealing with index [i - 1] corner case
        int[][] count = new int[s.length() + 1][26];

        for (int i = 1; i <= s.length(); i++) {
            for (int alph = 0; alph < 26; alph++) {
                count[i][alph] = count[i - 1][alph];
            }
            count[i][s.charAt(i - 1) - 'a']++;
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(canBePalidrome(s, count, q[0], q[1], q[2]));
        }
        return res;
    }

    // if all alphabets occur even-number times, for sure it can be rearranged to palindrome
    // if some alphabets occur odd-number times, by replacing half of them with the values of the other half, it will be palindrome
    private boolean canBePalidrome(String s, int[][] count, int left, int right, int replace) {
        int oddNumber = 0;
        for (int i = 0; i < 26; i++) {
            if ((count[right + 1][i] - count[left][i]) % 2 != 0) {  // alphabet i occurs even times in range s[left] ~ s[right]
                oddNumber++;
            }
        }
        return replace >= oddNumber / 2;
    }
}
