package medium;

public class MinimumSwapstoMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int xy = 0; // count of s1[i] = 'x' and s2[i] = 'y'
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }

        // total number of x and y is not equal, the two sequence cannot equal
        if ((xy + yx) % 2 != 0) {
            return -1;
        }

        // 'xx' and 'yy' need 1 swap
        if (xy % 2 == 0 && yx % 2 == 0) {
            return xy / 2 + yx / 2;
        }

        // prioritize the 'xx' 'yy' case
        return Math.abs(xy - yx) / 2 + Math.min(xy, yx) + 1;
    }
}
