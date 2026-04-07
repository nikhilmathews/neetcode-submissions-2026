class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return maxProfit(prices, 0, true, memo);
    }

    private int maxProfit(int[] prices, int index, boolean buying, int[][] memo) {
        if(index >= prices.length) {
            return 0;
        }
        if(buying) {
            if(memo[index][0] > -1) {
                return memo[index][0];
            }
            else {
                memo[index][0] = Math.max(maxProfit(prices, index + 1, false, memo) - prices[index], maxProfit(prices, index + 1, true, memo));
                return memo[index][0];
            }
        }
        else {
            if(memo[index][1] > -1) {
                return memo[index][1];
            }
            else {
            memo[index][1] =  Math.max(prices[index] + maxProfit(prices, index + 2, true, memo), maxProfit(prices, index + 1, false, memo));
            return memo[index][1];
            }
        }
    }
}
