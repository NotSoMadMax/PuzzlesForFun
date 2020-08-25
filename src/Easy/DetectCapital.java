package Easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (c - 'A' <= 25) {    // is upper case
                count++;
            }
        }

        if (count == 0) {
            return true;
        } else if (count == 1 && chars[0] - 'A' <= 25) {
            return true;
        } else if (count == chars.length) {
            return true;
        } else {
            return false;
        }
    }
}
