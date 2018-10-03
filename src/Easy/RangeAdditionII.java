package Easy;

class RangeAdditionII {
    private int maxCount(int m, int n, int[][] ops) {
        if(ops == null || ops.length < 1 || ops[0].length < 1)
            return m*n;

        for(int i = 0; i < ops.length; i++){
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }

        return m*n;
    }
}
