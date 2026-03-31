class Solution {
    public int jump(int[] nums) {
        return jump(nums, 0, new int[nums.length]);
    }

    private int jump(int[] nums, int index, int[] memo) {
        if(index >= nums.length - 1) {
            return 0;
        }
        if(memo[index] > 0) {
            return memo[index];
        }
        int minJumps = Integer.MAX_VALUE;
        for(int i=1; i <= nums[index]; i++) {
            int minJumpsFurther = jump(nums, index + i, memo);
            if(minJumpsFurther < Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + minJumpsFurther);
            }
        }
        memo[index] = minJumps;
        return minJumps;
    }
}
