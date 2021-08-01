package Easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];

        s.chars().forEach(c -> counter[c - 'a']++);
        t.chars().forEach(c -> counter[c - 'a']--);

        for(int c : counter) {
            if(c != 0)
                return false;
        }
        return true;
    }
}
