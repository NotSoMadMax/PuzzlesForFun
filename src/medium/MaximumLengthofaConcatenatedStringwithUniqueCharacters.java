class Solution {
    public int maxLength(List<String> arr) {
        boolean[] usedChars = new boolean[26];
        
        int maxLen = 0;
        for(int i = 0; i < arr.size(); i++){
            maxLen = Math.max(maxLen, search(i, arr, usedChars));
        }
        return maxLen;
    }
    
    private int search(int start, List<String> arr, boolean[] usedChars) {
        if(start >= arr.size()) {
            return 0;
        }
        for(char c : arr.get(start).toCharArray()) {
            if(usedChars[c - 'a']) {
                return 0;
            }
        }
        
        for(char c : arr.get(start).toCharArray()) {
            if(usedChars[c - 'a']) {
                markChars(usedChars, arr.get(start), false);
                return 0;
            }
            usedChars[c - 'a'] = true;
        }
        
        int maxLen = 0;
        for(int i = start + 1; i < arr.size(); i++) {
            maxLen = Math.max(maxLen, search(i, arr, usedChars));
        }
        
        markChars(usedChars, arr.get(start), false);
        return arr.get(start).length() + maxLen;
    }
    
    private void markChars(boolean[] usedChars, String s, boolean markTo) {
        for(char c : s.toCharArray()) {
            usedChars[c - 'a'] = markTo;
        }
    }
}