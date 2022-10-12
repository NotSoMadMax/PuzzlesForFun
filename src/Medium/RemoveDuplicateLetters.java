class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }
        
        int[] counter = new int[26]; 
        boolean[] used =  new boolean[26];
        for(char c : s.toCharArray()){
            counter[c - 'a'] += 1;
        }
        
        StringBuilder result = new StringBuilder();
        result.append('0');     // ASCII minimum
        for(char c : s.toCharArray()){
            counter[c - 'a'] -= 1;
            if(used[c - 'a']) {
                continue;
            } 
            
            while (c < result.charAt(result.length() - 1) && counter[result.charAt(result.length() - 1) - 'a'] > 0) {
                char lastChar = result.charAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                used[lastChar - 'a'] = false;
            }
            result.append(c);
            used[c - 'a'] = true;
            
        }
        
        result.deleteCharAt(0);
        return result.toString();
    }
}
