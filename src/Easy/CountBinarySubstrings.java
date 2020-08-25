package Easy;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int prevCount = -1;
        int curCount = 0;
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            curCount = i - j;   // count of consecutive sequence

            if (prevCount != -1) {    // compare with previous consecutive sequence
                res += Integer.min(prevCount, curCount);
            }

            prevCount = curCount;
        }

        return res;
    }
}
