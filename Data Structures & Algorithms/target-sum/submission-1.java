class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, 0, target);
    }
    private int findTargetSumWays(int[] nums, int index, int target) {
        if(index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, index + 1, target + nums[index]) + findTargetSumWays(nums, index + 1, target - nums[index]);
    }
}
