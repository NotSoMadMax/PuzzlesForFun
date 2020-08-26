package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReformatTheString {
    public String reformat(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        List<Character> digits = new ArrayList<>();
        List<Character> alphb = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                alphb.add(c);
            } else {
                digits.add(c);
            }
        }

        if (Math.abs(digits.size() - alphb.size()) <= 1) {
            return assembleLists(digits, alphb);
        } else {
            return "";
        }
    }

    // assume list1.size() >= list2.size()
    private String assembleLists(List<Character> list1, List<Character> list2) {
        if (list1.size() < list2.size()) {
            return assembleLists(list2, list1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            sb.append(list1.get(i));
            if (i < list2.size()) {
                sb.append(list2.get(i));
            }
        }
        return sb.toString();
    }
}
