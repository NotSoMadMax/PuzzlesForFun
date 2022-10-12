class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList == null || secondList == null || firstList.length < 1 || secondList.length < 1) {
            return new int[0][0];
        }
        
        List<int[]> inter = new ArrayList<>();
        int cur1 = 0;
        int cur2 = 0;
        while(cur1 < firstList.length && cur2 < secondList.length) {
            if (firstList[cur1][0] > secondList[cur2][1]) {
                cur2++;
            } else if(firstList[cur1][1] < secondList[cur2][0]) {
                cur1++;
            } else {
                inter.add(new int[]{Math.max(firstList[cur1][0], secondList[cur2][0]), Math.min(firstList[cur1][1], secondList[cur2][1])});
                if(firstList[cur1][1] < secondList[cur2][1]) {
                    cur1++;
                } else if(firstList[cur1][1] > secondList[cur2][1]) {
                    cur2++;
                } else {
                    cur1++;
                    cur2++;
                }
            }
        }
        
        if(inter.size() == 0) {
            return new int[0][0];
        }
        
        int[][] res = new int[inter.size()][2];
        for(int i = 0; i < inter.size(); i++){
            res[i] = inter.get(i);
        }
        return res;
    }
}