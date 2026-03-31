class Solution {
    public int numDecodings(String s) {
        return numDecodings(s, 0, new int[s.length()]);
    }
    private int numDecodings(String s, int idx, int[] memo) {
        if(idx == s.length()) {
            return 1;
        }
        else if(idx > s.length()) {
            return 0;
        }
        if(memo[idx] > 0) {
            return memo[idx];
        }
        if(s.charAt(idx) - '0' == 0) {
            return 0;
        }
        else if(s.charAt(idx) - '0' == 1) {
            memo[idx] = numDecodings(s, idx + 1, memo) + numDecodings(s, idx + 2, memo);
        }
        else if(s.charAt(idx) - '0' == 2) {
            if(idx + 1 < s.length() && s.charAt(idx + 1) - '0' < 7) {
                memo[idx] = numDecodings(s, idx + 1, memo) + numDecodings(s, idx + 2, memo);
            }
            else {
                memo[idx] = numDecodings(s, idx + 1, memo);
            }
        }
        else {
            memo[idx] = numDecodings(s, idx + 1, memo);
        }
        return memo[idx];
    }
}
