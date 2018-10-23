package medium;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if(s == null || s.length() < 1)
            return s;

        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");

        for(int i = words[0].length() - 1; i >= 0; i--)
            sb.append(words[0].charAt(i));

        for(int i = 1; i < words.length; i++){
            sb.append(" ");
            for(int j = words[i].length() - 1; j >= 0; j--)
                sb.append(words[i].charAt(j));
        }

        return sb.toString();
    }
}
