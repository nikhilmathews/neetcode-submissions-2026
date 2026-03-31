class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return lcs(text1, text2, 0, 0, memo);
    }
    private int lcs(String text1, String text2, int idx1, int idx2, int[][] memo) {
        if(idx1 >= text1.length() || idx2>=text2.length()) {
            return 0;
        }
        if(memo[idx1][idx2] > -1) {
            return memo[idx1][idx2];
        }
        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            memo[idx1][idx2] = 1 + lcs(text1, text2, idx1 + 1, idx2 + 1, memo);
        }
        else {
            memo[idx1][idx2] = Math.max(lcs(text1, text2, idx1 + 1, idx2, memo), lcs(text1, text2, idx1, idx2 + 1, memo));
        }
        return memo[idx1][idx2];
    }
}
