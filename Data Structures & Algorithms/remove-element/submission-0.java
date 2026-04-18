class Solution {
    public int removeElement(int[] nums, int val) {
        Queue<Integer> replacementIndices = new ArrayDeque();
        int count = 0;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == val) {
                replacementIndices.offer(i);
            }
            else {
                count++;
                if(!replacementIndices.isEmpty()) {
                    int indexToReplace = replacementIndices.poll();
                    nums[indexToReplace] = nums[i];
                    replacementIndices.offer(i);
                }
            }
        }
        return count;
    }
}