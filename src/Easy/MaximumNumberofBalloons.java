package Easy;

public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7) {
            return 0;
        }

        // b,a,l,o,n
        int[] count = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'b') {
                count[0]++;
            } else if (c == 'a') {
                count[1]++;
            } else if (c == 'l') {
                count[2]++;
            } else if (c == 'o') {
                count[3]++;
            } else if (c == 'n') {
                count[4]++;
            }
        }
        count[2] /= 2;
        count[3] /= 2;

        int res = count[0];
        for (int c : count) {
            res = Math.min(res, c);
        }

        return res;
    }
}
