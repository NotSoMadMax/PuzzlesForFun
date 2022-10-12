package medium;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return 0;
        }

        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int cur = 0;
        int curCost = 0;
        int maxLen = 0;
        for (int start = 0; start < s.length(); start++) {
            while (cur < s.length()) {
                if (curCost + costs[cur] > maxCost) {
                    break;
                }
                curCost += costs[cur++];
            }
            maxLen = Math.max(maxLen, cur - start);
            curCost -= costs[start];
        }

        return maxLen;
    }
}
