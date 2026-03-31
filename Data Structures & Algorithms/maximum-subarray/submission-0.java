class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = nums[0];
        int maxSum = runningSum;
        for(int i=1; i < nums.length; i++) {
            if(runningSum < 0) {
                runningSum = 0;
            }
            runningSum += nums[i];
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}
