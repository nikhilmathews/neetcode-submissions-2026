class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(seenIndex.containsKey(complement)) {
                return new int[]{seenIndex.get(complement), i};
            }
            seenIndex.put(nums[i], i);
        }
        return null;
    }
}
