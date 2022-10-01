class Solution {
    public int minimumDeletions(String s) {
        if(s.length() < 2) {
            return 0;
        }
        
        // after i, only b, including i
        int[] aAfter = new int[s.length()]; 
        int[] bBefore = new int[s.length()];
        
        bBefore[0] = s.charAt(0) == 'b' ? 1 : 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == 'b') {
                bBefore[i] = bBefore[i - 1] + 1;
            } else {
                bBefore[i] = bBefore[i - 1];
            }
        }
        
        aAfter[s.length() - 1] = s.charAt(s.length() - 1) == 'a' ? 1 : 0;
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) == 'a') {
                aAfter[i] = aAfter[i + 1] + 1;
            } else {
                aAfter[i] = aAfter[i + 1];
            }
        }
        
        int res = Math.min(aAfter[0], bBefore[s.length() - 1]);
        for(int i = 0; i < s.length(); i++) {
            res = Math.min(res, aAfter[i] + bBefore[i] - 1);
        }
        return res;
    }

    // same algorithm, less space complexity
    public int minimumDeletions2(String s) {
        if(s.length() < 2) {
            return 0;
        }
        
        int aCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aCount++;
            }
        }
        
        int res = Math.min(aCount, s.length() - aCount);
        int bCount = 0;
        
        // after i, only b, including i
        for(char c : s.toCharArray()) {
            if (c == 'a'){ // need to delete
                aCount--;
                res = Math.min(res, aCount + bCount);
            } else {
                bCount++;
                res = Math.min(res, aCount + bCount - 1);
            }
        }
        
        return res;
    }
}