class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int expectedSum = 0;
        for (int i=0; i <= nums.length; i++) {
            expectedSum += i;
        }
        return expectedSum - sum;
    }
}
