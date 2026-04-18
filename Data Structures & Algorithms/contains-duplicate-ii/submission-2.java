class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            int num = nums[i];
            if(!lastSeenIndex.containsKey(num)) {
                lastSeenIndex.put(num, i);
            }
            else {
                if(i - lastSeenIndex.get(num) <= k) {
                    return true;
                }
                lastSeenIndex.put(num, i);
            }
        }
        return false;
    }
}