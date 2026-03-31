class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Traverse each row and confirm.
        for(int i=0; i < board.length; i++) {
            Set<Character> seenNums = new HashSet();
            for(int j=0; j < board[0].length; j++) {
                if(board[i][j] != '.' && seenNums.contains(board[i][j])) {
                    return false;
                }
                else {
                    seenNums.add(board[i][j]);
                }
            }
        }
        // Traverse each column and confirm.
        for(int i=0; i < board.length; i++) {
            Set<Character> seenNums = new HashSet();
            for(int j=0; j < board[0].length; j++) {
                if(board[j][i] != '.' && seenNums.contains(board[j][i])) {
                    return false;
                }
                else {
                    seenNums.add(board[j][i]);
                }
            }
        }
        // Now check the 9x9 squares.
        for(int n = 0; n < 9; n++) {
            Set<Character> seenNums = new HashSet();
            for(int i=0; i < 3; i++) {
                for(int j=0; j < 3; j++) {
                    int x = i + ((n / 3) * 3);
                    int y = j + ((n % 3) * 3);
                    if(board[x][y] != '.' && seenNums.contains(board[x][y])) {
                        return false;
                    }
                    else {
                        seenNums.add(board[x][y]);
                    }
                }
            }
        }
        return true;
    }
}
