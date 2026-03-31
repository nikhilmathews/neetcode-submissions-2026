class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE);
    }
    private int lengthOfLIS(int[] nums, int index, int lastSeenNum) {
        if(index >= nums.length) {
            return 0;
        }
        if(lastSeenNum >= nums[index]) {
            return lengthOfLIS(nums, index + 1, lastSeenNum);
        }
        return Math.max(lengthOfLIS(nums, index + 1, lastSeenNum), 1 + lengthOfLIS(nums, index + 1, nums[index]));
    }
}
