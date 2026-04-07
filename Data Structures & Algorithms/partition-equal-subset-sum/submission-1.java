class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        if(totalSum % 2 > 0) {
            return false;
        }
        int target = totalSum / 2;
        int[][] memo = new int[nums.length][target];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return canPartition(nums, 0, 0, target, memo);
    }
    private boolean canPartition(int[] nums, int index, int runningSum, int target, int[][] memo) {
        if(runningSum == target) {
            return true;
        }
        if(index >= nums.length || runningSum > target) {
            return false;
        }
        if(memo[index][runningSum] > -1) {
            return memo[index][runningSum] == 1;
        }
        memo[index][runningSum] = canPartition(nums, index + 1, runningSum + nums[index], target, memo) || 
        canPartition(nums, index + 1, runningSum, target, memo) ? 1 : 0;
        return memo[index][runningSum] == 1;
    }
}
