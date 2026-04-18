class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        int res = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long product = (long) mid * mid;
            if(product == x) {
                return mid;
            }
            else if(product > x) {
                high = mid - 1;
            }
            else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
}