class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {
            int runningProduct = 1;
            for(int j=i; j < nums.length; j++) {
                runningProduct *= nums[j];
                maxProduct = Math.max(maxProduct, runningProduct);
            }
        }
        return maxProduct;
    }
}
