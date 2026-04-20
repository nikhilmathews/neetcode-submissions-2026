class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 1, new int[prices.length][2]);
    }
    private int maxProfit(int[] prices, int index, int buying, int[][] memo) {
        if(index >= prices.length) {
            return 0;
        }
        if(memo[index][buying] > 0) {
            return memo[index][buying];
        }
        if(buying > 0) {
            memo[index][buying] = Math.max(maxProfit(prices, index + 1, 1, memo), maxProfit(prices, index + 1, 0, memo) - prices[index]);
        }
        else {
            memo[index][buying] = Math.max(prices[index] + maxProfit(prices, index + 1, 1, memo),
            maxProfit(prices, index + 1, 0, memo));
        }
        return memo[index][buying];
    }
}