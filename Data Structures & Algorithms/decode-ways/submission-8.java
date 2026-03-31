class Solution {
    public int numDecodings(String s) {
        return numDecodings(s, 0);
    }
    private int numDecodings(String s, int idx) {
        if(idx == s.length()) {
            return 1;
        }
        if(idx > s.length()) {
            return 0;
        }
        if(s.charAt(idx) - '0' == 0) {
            return 0;
        }
        else if(s.charAt(idx) - '0' == 1) {
            return numDecodings(s, idx + 1) + numDecodings(s, idx + 2);
        }
        else if(s.charAt(idx) - '0' == 2) {
            if(idx + 1 < s.length() && s.charAt(idx + 1) - '0' < 7) {
                return numDecodings(s, idx + 1) + numDecodings(s, idx + 2);
            }
            else {
                return numDecodings(s, idx + 1);
            }
        }
        else {
            return numDecodings(s, idx + 1);
        }
    }
}
