class Solution {
    public int longestStrChain(String[] words) {
        
        Map<Integer, List<String>> lenToWords = new HashMap<>();
        Map<String, Integer> visitedDepth = new HashMap<>();
        for(String w : words) {
            lenToWords.putIfAbsent(w.length(), new ArrayList<>());
            lenToWords.get(w.length()).add(w);
        }
        
        int res = 1;
        for(String w : words) {
            res = Math.max(res, search(w, lenToWords, visitedDepth));
        }
        
        return res;
    }
    
    private int search(String cur, Map<Integer, List<String>> lenToWords, Map<String, Integer> visitedDepth) {
        if(!lenToWords.containsKey(cur.length() + 1)) {
            return 1;
        }
        
        if(visitedDepth.containsKey(cur)) {
            return visitedDepth.get(cur);
        }
        
        int maxDepth = 0;
        for(String w : lenToWords.get(cur.length() + 1)) {
            if(isPred(cur, w)) {
                maxDepth = Math.max(maxDepth, search(w, lenToWords, visitedDepth));
            }
        }
        visitedDepth.put(cur, maxDepth + 1);
        
        return maxDepth + 1;
    }
    
    private boolean isPred(String root, String word) {
        if(!(root.length() + 1 == word.length())){
            return false;
        }
        
        int i = 0;
        int j = 0;
        boolean inserted = false;
        while(i < root.length() && j < word.length()) {
            if(root.charAt(i) == word.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if(inserted) {
                return false;
            }
            
            inserted = true;
            j++;
        }
        return true;
    }
}