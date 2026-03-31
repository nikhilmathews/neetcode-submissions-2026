class Solution {
    public int climbStairs(int n) {
        int [] memo = new int[50];
        return climbStairs(n, memo);
    }

    private int climbStairs(int numStairs, int[] memo) {
        if(numStairs < 0) {
            return 0;
        }
        if(numStairs == 0) {
            return 1;
        }
        if(memo[numStairs] > 0) {
            return memo[numStairs];
        }
        int uniqueWays = climbStairs(numStairs - 1, memo) + climbStairs(numStairs - 2, memo);
        memo[numStairs] = uniqueWays;
        return uniqueWays;
    }
}
