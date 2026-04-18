class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> seenNums = new HashSet();
        int swapableIndex = 0;
        for(int i=0; i < nums.length; i++) {
            int num = nums[i];
            if(!seenNums.contains(num)) {
                seenNums.add(num);
                nums[swapableIndex] = num;
                swapableIndex++;
            }
        }
        return seenNums.size();
    }
}