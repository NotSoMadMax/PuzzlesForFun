package medium;

public class ReverseWordsInAString {
    private String reverseWords(String s) {
        if(s == null || s.length() < 1)
            return s;

        s = s.trim();
        String[] words = s.split("\\s+");

        if(words.length < 1)
            return "";

        int len = words.length;
        StringBuilder sb = new StringBuilder();
        sb.append(words[len - 1]);

        for(int i = len - 2; i >=0; i--){
            sb.append(" ");
            sb.append(words[i]);
        }

        return sb.toString();
    }
}
