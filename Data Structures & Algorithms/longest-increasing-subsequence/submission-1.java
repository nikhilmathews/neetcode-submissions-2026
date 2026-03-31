class Solution {
    public int lengthOfLIS(int[] nums) {
        Map<Pair<Integer, Integer>, Integer> memo = new HashMap();
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE, memo);
    }
    private int lengthOfLIS(int[] nums, int index, int lastSeenNum, Map<Pair<Integer, Integer>, Integer> memo) {
        if(index >= nums.length) {
            return 0;
        }
        Pair<Integer, Integer> memoKey = new Pair(index, lastSeenNum);
        if(memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        if(lastSeenNum >= nums[index]) {
            memo.put(memoKey, lengthOfLIS(nums, index + 1, lastSeenNum, memo));
        }
        else {
            memo.put(memoKey, Math.max(lengthOfLIS(nums, index + 1, lastSeenNum, memo), 1 + lengthOfLIS(nums, index + 1, nums[index], memo)));
        }
        return memo.get(memoKey);
    }
}
