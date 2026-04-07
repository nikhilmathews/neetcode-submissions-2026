class Solution {
    public double myPow(double x, int n) throws Exception {
        if(x == 0 && n < 0) {
            throw new Exception("Can't divide by 0");
        }
        if(n == 0) {
            return (double) 1.0;
        }
        double runningProduct = 1.0;
        if(n > 0) {
            while(n > 0) {
                runningProduct *= x;
                n--;
            }
            return runningProduct;
        }
        else {
            while(n < 0) {
                runningProduct /= x;
                n++;
            }
            return runningProduct;
        }
    }
}
