class Solution {
    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        return Math.max(rob(nums, 1, 0, memo), nums[0] + rob(nums, 2, 1, memo));
    }
    private int rob(int[] nums, int index, int robbedFirst, int[][] memo) {
        if(index >= nums.length) {
            return 0;
        }
        if(index == nums.length - 1 && robbedFirst > 0) {
            return 0;
        }
        if(memo[index][robbedFirst] > 0) {
            return memo[index][robbedFirst];
        }
        memo[index][robbedFirst] = Math.max(nums[index] + rob(nums, index + 2, robbedFirst, memo), 
        rob(nums, index + 1, robbedFirst, memo));
        return memo[index][robbedFirst];
    }
}
