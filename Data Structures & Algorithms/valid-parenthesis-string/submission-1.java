class Solution {
    public boolean checkValidString(String s) {
        int[][] memo = new int[s.length()][100];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return checkValidString(s, 0, 0, memo);
    }
    private boolean checkValidString(String s, int index, int openCount, int[][] memo) {
        if(openCount < 0) {
            return false;
        }
        if(index >= s.length()) {
            return openCount == 0;
        }
        if(memo[index][openCount] >= 0) {
            return memo[index][openCount] == 1;
        }
        Character curr = s.charAt(index);
        if(curr == '(') {
            memo[index][openCount] = checkValidString(s, index + 1, openCount + 1, memo) ? 1 : 0;
        }
        else if(curr == ')') {
            memo[index][openCount] = checkValidString(s, index + 1, openCount - 1, memo) ? 1 : 0;
        }
        else {
            memo[index][openCount] = (checkValidString(s, index + 1, openCount, memo) || 
            checkValidString(s, index + 1, openCount + 1, memo) ||
            checkValidString(s, index + 1, openCount- 1, memo)) ? 1 : 0;
        }
        return memo[index][openCount] == 1;
    }
}
