class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJump(nums, 0, memo);
    }
    private boolean canJump(int[] nums, int index, int[] memo) {
        if(index == nums.length - 1) {
            return true;
        }
        if(memo[index] > -1) {
            return memo[index] == 0 ? false : true;
        }
        boolean canMakeEnd = false;
        for(int i=1; i <= nums[index]; i++) {
            if(canJump(nums, index + i, memo)) {
                canMakeEnd = true;
                break;
            }
        }
        memo[index] = canMakeEnd == true ? 1 : 0;
        return canMakeEnd;
    }
}
