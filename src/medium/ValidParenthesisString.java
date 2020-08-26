package medium;

import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        return search(0, s, 0);
    }

    private boolean search(int counter, String s, int position) {
        if (position == s.length()) {
            return counter == 0;
        }

        for (int i = position; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter--;
            } else if (s.charAt(i) == ')') {
                if (counter >= 0) {
                    return false;
                }
                counter++;
            } else {    // is *
                int tempCounter = counter;
                tempCounter--;
                boolean case1 = search(tempCounter, s, i + 1);

                tempCounter = counter;
                tempCounter++;
                boolean case2 = search(tempCounter, s, i + 1);

                boolean case3 = search(counter, s, i + 1);
                return case1 || case2 || case3;
            }
        }

        return counter == 0;
    }
}
