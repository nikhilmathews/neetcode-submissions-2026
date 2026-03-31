class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1Index = 0;
        int w2Index = 0;
        StringBuilder sb = new StringBuilder();
        while(w1Index < word1.length() || w2Index < word2.length()) {
            if(w1Index < word1.length()) {
                sb.append(word1.charAt(w1Index));
            }
            if(w2Index < word2.length()) {
                sb.append(word2.charAt(w2Index));
            }
            w1Index++;
            w2Index++;
        }
        return sb.toString();
    }
}