package Easy;

public class BuddyStrings {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] charCount = new int[26];
        int diffA = 0;
        int diffB = 0;
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
            if (a.charAt(i) != b.charAt(i)) {
                if (diffCount == 0) {
                    diffCount++;
                    diffA = i;
                } else if (diffCount == 1) {
                    diffCount++;
                    diffB = i;
                } else {    // differ more than two char
                    return false;
                }
            }
        }

        if (diffCount == 0) {
            for (int i : charCount) {
                if (i > 1) {    // A equals B, but some char has repeats
                    return true;
                }
            }
            return false;
        } else {
            return a.charAt(diffA) == b.charAt(diffB) && a.charAt(diffB) == b.charAt(diffA);
        }
    }
}
