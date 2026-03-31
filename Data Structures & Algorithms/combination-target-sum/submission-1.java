class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList();
        comboSum(nums, target, 0, new ArrayList(), resultList);
        return resultList;
    }

    private void comboSum(int[] nums, int target, int index, List<Integer> usedNums, List<List<Integer>> resultList) {
        if(target < 0) {
            return;
        }
        else if(target == 0) {
            resultList.add(new ArrayList(usedNums));
        }
        else {
            for(int i=index; i < nums.length; i++) {
                usedNums.add(nums[i]);
                comboSum(nums, target - nums[i], i, usedNums, resultList);
                usedNums.remove(usedNums.size()-1);
            }
        }
    }
}
