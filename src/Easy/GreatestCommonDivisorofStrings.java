package Easy;

public class GreatestCommonDivisorofStrings {

    public String gcdOfStrings(String str1, String str2) {
        // let str1 be the longer of the two
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        if (str1.equals(str2)) {
            return str1;
        }

        int longer = str1.length();
        int shorter = str2.length();

        // e.g. str1: {block}{block}{block}{block} str2: {block}{block}
        // Their prefix must equal
        for (int i = 0; i < shorter; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return "";
            }
        }

        return gcdOfStrings(str2, str1.substring(shorter));
    }
}
