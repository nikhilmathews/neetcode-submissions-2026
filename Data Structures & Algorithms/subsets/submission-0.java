class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        subsets(nums, 0, new ArrayList(), result);
        return result;
    }

    private void subsets(int[] nums, int idx, List<Integer> currSubset, List<List<Integer>> result) {
        if(idx >= nums.length) {
            result.add(new ArrayList(currSubset));
            return;
        }
        subsets(nums, idx + 1, currSubset, result);
        currSubset.add(nums[idx]);
        subsets(nums, idx + 1, currSubset, result);
        currSubset.remove(currSubset.size() - 1);
    }
}
