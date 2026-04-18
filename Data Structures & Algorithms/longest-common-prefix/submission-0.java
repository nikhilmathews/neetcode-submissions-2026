class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            if(index >= strs[0].length()) {
                return sb.toString();
            }
            Character comparison = strs[0].charAt(index);
            for(String str : strs) {
                if(index >= str.length() || str.charAt(index) != comparison) {
                    return sb.toString();
                }
            }
            sb.append(comparison);
            index++;
        }
    }
}