class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> diffToProf = new TreeMap<>();
        for(int i = 0; i < difficulty.length; i++) {
            if(diffToProf.containsKey(difficulty[i])) {
                diffToProf.put(difficulty[i], Math.max(diffToProf.get(difficulty[i]), profit[i]));
            } else {
                diffToProf.put(difficulty[i], profit[i]);
            }
        }
        
        int curMax = diffToProf.get(diffToProf.firstKey());
        for(Integer diff : diffToProf.keySet()) {
            if(diffToProf.get(diff) < curMax) {
                diffToProf.put(diff, curMax);
            } else {
                curMax = diffToProf.get(diff);
            }
        }
        
        int res = 0;
        for(int diff : worker) {
            if (diffToProf.floorKey(diff) == null) {    // all jobs are harder
                continue;
            }
            res += diffToProf.get(diffToProf.floorKey(diff));
        }
        return res;
    }

    // Method2, using array instead of sortedMap
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int[] diffToProf = new int[100001]; // max profit up to difficulty i
        for(int i = 0; i < profit.length; i++){
            diffToProf[difficulty[i]] = Math.max(profit[i], diffToProf[difficulty[i]]);
        }
        

        for(int i = 1; i < diffToProf.length; i++) {
            diffToProf[i] = Math.max(diffToProf[i - 1], diffToProf[i]);
        }
        
        int res = 0;
        for(int diff : worker) {
            res += diffToProf[diff];
        }
        
        return res;
    }
}