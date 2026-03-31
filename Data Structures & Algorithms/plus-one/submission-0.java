class Solution {
    public int[] plusOne(int[] digits) {
        int overflow = 1;
        for(int i = digits.length - 1; i >= 0 && overflow > 0; i--) {
            int digit = digits[i];
            if (digit < 9) {
                digits[i] += overflow;
                overflow = 0;
                break;
            }
            overflow = 1;
            digits[i] = 0;
        }
        if(overflow == 1) {
            int[] totalNum = new int[digits.length + 1];
            totalNum[0] = 1;
            for(int i=1; i < totalNum.length; i++) {
                totalNum[i] = digits[i-1];
            }
            return totalNum;
        }
        return digits;
    }
}
