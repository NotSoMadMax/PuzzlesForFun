class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length < 1) {
            return 0;
        }
        
        int[] masks = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                masks[i] |= 1 << (c - 'a'); // move the 1 bit left, using the last 26 bits as a mark
            }
        }
        
        int result = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < i; j++) {
                if((masks[i] & masks[j]) == 0) { // has no overlapping 1 bit
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}
