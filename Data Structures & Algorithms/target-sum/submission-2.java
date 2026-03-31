class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Pair<Integer, Integer>, Integer> memo = new HashMap();
        return findTargetSumWays(nums, memo, 0, target);
    }
    private int findTargetSumWays(int[] nums, Map<Pair<Integer, Integer>, Integer> memo, int index, int target) {
        if(index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        Pair<Integer, Integer> pair = new Pair(index, target);
        if(memo.containsKey(pair)) {
            return memo.get(pair);
        }
        memo.put(pair, findTargetSumWays(nums, memo, index + 1, target + nums[index]) + findTargetSumWays(nums, memo, index + 1, target - nums[index]));
        return memo.get(pair);
    }
}
