class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (high + low) / 2;
            if(nums[mid] > target) {
                high = mid - 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                low = mid;
                break;
            }
        }
        if(nums[low] != target) {
            return new int[]{-1, -1};
        }
        int leftLow = 0;
        int rightLow = low;
        while(leftLow < rightLow) {
            int mid = (leftLow + rightLow) / 2;
            if(nums[mid] < target) {
                leftLow = mid + 1;
            }
            else {
                rightLow = mid;
            }
        }

        int leftHigh = low;
        int rightHigh = nums.length - 1;
        while(leftHigh < rightHigh) {
            int mid = (leftHigh + rightHigh + 1) / 2;
            if(nums[mid] > target) {
                rightHigh = mid - 1;
            }
            else {
                leftHigh = mid;
            }
        }

        return new int[]{leftLow, rightHigh};
    }
}