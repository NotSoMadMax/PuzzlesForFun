package medium;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] countS = new int[26];
        int[] counrT = new int[26];

        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counrT[c - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(countS[i] - counrT[i]);
        }

        return res / 2;
    }
}
