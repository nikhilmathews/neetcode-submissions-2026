class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            alphabet[c - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            alphabet[c - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
