package medium;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        search(res, 0, S);
        return res;
    }

    private boolean search(List<Integer> res, int start, String s) {
        if (start >= s.length() && res.size() >= 3) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            String num = s.substring(start, i + 1);
            if (num.length() > 1 && num.charAt(0) == '0') { // leading zeroes
                break;
            }
            long number = Long.parseLong(num);
            if (number > Integer.MAX_VALUE) {
                break;
            }

            int len = res.size();
            if (len >= 2 && number != res.get(len - 1) + res.get(len - 2)) {
                continue;
            }

            res.add(Integer.parseInt(num));
            if (search(res, i + 1, s)) {    // only need one answer
                return true;
            } else {
                res.remove(res.size() - 1);
            }
        }

        return false;
    }
}
