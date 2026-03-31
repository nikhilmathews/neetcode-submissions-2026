class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[5001][coins.length];
        return change(amount, coins, 0, memo);
    }

    private int change(int amount, int[] coins, int index, int[][] memo) {
        if(amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        if(memo[amount][index] > 0) {
            return memo[amount][index];
        }
        int totalPaths = 0;
        for(int i = index; i < coins.length; i++) {
            totalPaths += change(amount - coins[i], coins, i, memo);
        }
        memo[amount][index] = totalPaths;
        return memo[amount][index];
    }
}
