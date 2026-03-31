class Solution {
    public boolean isPalindrome(String s) {
        String lowercase = s.toLowerCase();
        int i = 0;
        int j = lowercase.length()-1;
        while (i < j) {
            Character left = lowercase.charAt(i);
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }
            Character right = lowercase.charAt(j);
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }
            if(!left.equals(right)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
