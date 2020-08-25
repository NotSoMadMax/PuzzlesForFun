package Easy;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int maxCount = 0;
        while (i < s.length()) {
            int count = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            maxCount = Integer.max(maxCount, count);
            i++;
        }
        return maxCount;
    }
}
