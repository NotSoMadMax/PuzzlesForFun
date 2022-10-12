class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        search(k, n, 1, new ArrayList<>(), res);
        return res;
    }
    
    private void search(int k, int n, int start, List<Integer> cur, List<List<Integer>> res) {
        if(k == 0 && n == 0) {
            res.add(new ArrayList<>(cur));
            return;
        } 
        
        if(k == 0 && n != 0) {
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            cur.add(i);
            search(k - 1, n - i, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}