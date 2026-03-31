class Solution {
    public int maxProfit(int[] prices) {
        int minPriceSeen = 101;
        int maxProfit = 0;
        for(int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPriceSeen);
            minPriceSeen = Math.min(minPriceSeen, price);
        }
        return maxProfit;
    }
}
