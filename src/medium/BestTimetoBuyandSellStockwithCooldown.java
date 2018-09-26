package medium;

class BestTimetoBuyandSellStockwithCooldown {
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);

        for (int i = 2; i < len; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);   // don't sell at i . vs.  sell at i
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);  // don't buy at i vs. buy at i
        }

        return sell[len - 1];
    }
}
