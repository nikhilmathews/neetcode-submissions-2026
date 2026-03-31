class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0, new int[word1.length()][word2.length()]);
    }
    private int minDistance(String word1, String word2, int idx1, int idx2, int[][] memo) {
        if(idx1 >= word1.length()) {
            return word2.length() - idx2;
        }
        if(idx2 >= word2.length()) {
            return word1.length() - idx1;
        }
        if(memo[idx1][idx2] > 0) {
            return memo[idx1][idx2];
        }
        if(word1.charAt(idx1) == word2.charAt(idx2)) {
            memo[idx1][idx2] = minDistance(word1, word2, idx1 + 1, idx2 + 1, memo);
        }
        else {
            memo[idx1][idx2] = 1 + Math.min(Math.min(minDistance(word1, word2, idx1 + 1, idx2 + 1, memo), minDistance(word1, word2, idx1 + 1, idx2, memo)), minDistance(word1, word2, idx1, idx2 + 1, memo));
        }
        return memo[idx1][idx2];
    }
}
