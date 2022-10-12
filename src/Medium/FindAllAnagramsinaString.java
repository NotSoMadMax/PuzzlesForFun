class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) {
            return res;
        }
        
        int[] targetCharCount = new int[26];
        int[] windowCount =  new int[26];
        
        for(int i = 0; i < p.length(); i++) {
            targetCharCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }
        if (countEqual(targetCharCount, windowCount)) {
            res.add(0);
        }
        for(int i = 1; i <= s.length() - p.length(); i++) {
            windowCount[s.charAt(i - 1) - 'a']--;
            windowCount[s.charAt(i + p.length() - 1) - 'a']++;
            if (countEqual(targetCharCount, windowCount)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean countEqual(int[] count1, int[] count2) {
        for(int i = 0; i < count1.length; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}