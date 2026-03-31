class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        permute(nums, new boolean[nums.length], new ArrayList(), results);
        return results;
    }

    private void permute(int[] nums, boolean[] taken, List<Integer> currCombo, List<List<Integer>> result) {
        if(currCombo.size() == nums.length) {
            result.add(new ArrayList(currCombo));
            return;
        }
        for(int i=0; i < nums.length; i++) {
            if(!taken[i]) {
                taken[i] = true;
                currCombo.add(nums[i]);
                permute(nums, taken, currCombo, result);
                taken[i] = false;
                currCombo.remove(currCombo.size() - 1);
            }
        }
    }
}
