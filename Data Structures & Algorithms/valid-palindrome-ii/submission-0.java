class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, 1);
    }
    private boolean validPalindrome(String s, int low, int high, int deletesLeft) {
        if(low >= high) {
            return true;
        }
        if(s.charAt(low) == s.charAt(high)) {
            return validPalindrome(s, low + 1, high - 1, deletesLeft);
        }
        else if(deletesLeft > 0){
            return validPalindrome(s, low + 1, high, deletesLeft - 1) || validPalindrome(s, low, high - 1, deletesLeft - 1);
        }
        else {
            return false;
        }
    }
}