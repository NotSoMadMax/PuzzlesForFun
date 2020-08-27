package medium;

import java.util.Arrays;

public class CheckIfaStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        return canBreak(count1, count2) || canBreak(count2, count1);
    }

    // return true if countA can break countB
    private boolean canBreak(int[] countA, int[] countB) {
        int[] a = Arrays.copyOf(countA, 26);
        int[] b = Arrays.copyOf(countB, 26);

        // starting with small digits in A, can always find one smaller match in B
        for (int i = 0; i < 26; i++) {
            while (a[i] > 0) {
                boolean hasSmaller = false;
                for (int j = 0; j <= i; j++) {
                    if (b[j] > 0) { // Find one to match A
                        b[j]--;
                        hasSmaller = true;
                        break;
                    }
                }
                if (!hasSmaller) {
                    return false;
                }
                a[i]--;
            }
        }

        return true;
    }

    // Method 2: sort and compare
}
