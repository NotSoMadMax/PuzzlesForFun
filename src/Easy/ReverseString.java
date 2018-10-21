package Easy;

public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() < 1)
            return s;

        //StringBuffer sb = new StringBuffer(); // slower
        StringBuilder sb = new StringBuilder(); // faster
        char[] sa = s.toCharArray();

        for(int i = s.length() - 1; i >= 0; i--){
            //sb.append(s.charAt(i));
            sb.append(sa[i]);
        }

        return sb.toString();
    }


    // time limit exceeds
    /*
    public String reverseString(String s) {
        if(s == null || s.length() < 1)
            return s;

        String res = "";

        for(int i = s.length(); i >= 0; i--){
            res += s.charAt(i);
        }

        return res;
    }
    */
}
