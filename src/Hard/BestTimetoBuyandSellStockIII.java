package Hard;

class BestTimetoBuyandSellStockIII {
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        int[] left_best = new int[len];
        int cur_min = prices[0];
        int cur_best = 0;
        for (int i = 0; i < len; i++){
            if (prices[i] < cur_min)
                cur_min = prices[i];
            else{
                cur_best = Math.max(cur_best, prices[i] - cur_min);
                left_best[i] = cur_best;
            }
        }

        int best = left_best[len - 1];
        int right_max = prices[len - 1];
        int right_best = 0;
        for (int i = len - 1; i >= 0; i--){
            if (right_max < prices[i])
                right_max = prices[i];
            else
                right_best = Math.max(right_best, right_max - prices[i]);

            best = Math.max(best, right_best + left_best[i]);
        }

        return best;
    }
}
