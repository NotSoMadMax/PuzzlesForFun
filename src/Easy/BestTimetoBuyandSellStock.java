package Easy;

class BestTimetoBuyandSellStock {
    private static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        int cur_min = prices[0];
        int cur_best = 0;

        for (int i = 0; i < len; i++){
            if (prices[i] < cur_min)
                cur_min = prices[i];
            else
                cur_best = Math.max(cur_best, prices[i] - cur_min);
        }

        return cur_best;
    }


}
