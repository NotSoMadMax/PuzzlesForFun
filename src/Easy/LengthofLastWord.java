package Easy;

public class LengthofLastWord {
    private int lengthOfLastWord(String s) {
        int len = s.length();
        if (len < 1 || s == null)
        		return 0;
        
        String[] words = s.split(" ");
        
        if (words.length == 0)
        		return 0;
        
        return words[words.length - 1].length();
    }
}
