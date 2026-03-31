class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = coinChange(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private int coinChange(int[] coins, int amount, int[] memo) {
        if(amount == 0) {
            return 0;
        }
        if(memo[amount] > -1) {
            return memo[amount];
        }
        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(coin <= amount) {
                int remainingCoins = coinChange(coins, amount - coin, memo);
                if(remainingCoins < Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, 1 + remainingCoins);
                }
            }
        }
        memo[amount] = minCoins;
        return minCoins;
    }
}
