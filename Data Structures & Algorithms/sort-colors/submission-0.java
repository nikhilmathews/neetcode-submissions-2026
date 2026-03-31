class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for(int num : nums) {
            if(num == 0) {
                redCount++;
            }
            else if(num == 1) {
                whiteCount++;
            }
            else {
                blueCount++;
            }
        }
        int index = 0;
        while(redCount > 0) {
            nums[index] = 0;
            index++;
            redCount--;
        }
        while(whiteCount > 0) {
            nums[index] = 1;
            index++;
            whiteCount--;
        }
        while(blueCount > 0) {
            nums[index] = 2;
            index++;
            blueCount--;
        }
    }
}