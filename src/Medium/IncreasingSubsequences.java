class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        search(0, nums, new ArrayList<>(), res);
        return res;
    }
    
    private void search(int start, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() > 1){
            res.add(new ArrayList<>(cur));
        }
        
        Set<Integer> used = new HashSet<>();
        for(int i = start; i < nums.length; i++) {
            if(cur.size() > 0 && cur.get(cur.size() - 1) > nums[i]) {
                continue;
            }
            
            if(used.contains(nums[i])) { // don't use the same number twice at the same level
                continue;
            }
            
            cur.add(nums[i]);
            used.add(nums[i]);
            search(i + 1, nums, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}