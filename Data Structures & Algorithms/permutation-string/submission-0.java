class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(int i=0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }
        while(left <= right && right < s2.length()) {
            s2Count[s2.charAt(right) - 'a']++;
            if(right - left + 1 == s1.length()) {
                if(Arrays.equals(s1Count, s2Count)) {
                    return true;
                }
                else {
                    s2Count[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
            right++;
        }
        return false;
    }
}
