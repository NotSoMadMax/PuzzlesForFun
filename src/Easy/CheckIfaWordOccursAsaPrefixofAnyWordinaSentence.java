package Easy;

public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s+");
        int res = -1;
        for (int i = 0; i < words.length; i ++) {
            if (isPrefix(searchWord, words[i])) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    private boolean isPrefix(String prefix, String word) {
        if (word.length() < prefix.length()) {
            return false;
        }
        return prefix.equals(word.substring(0, prefix.length()));
    }
}
