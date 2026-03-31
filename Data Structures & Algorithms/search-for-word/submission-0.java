class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(exist(board, word, 0, i, j, new int[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int x, int y, int[][] visited) {
        if(index >= word.length()) {
            return true;
        }
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index) || visited[x][y] == 1) {
            return false;
        }
        visited[x][y] = 1;
        for(int[] dir : directions) {
            if(exist(board, word, index + 1, x + dir[0], y + dir[1], visited)) {
                return true;
            }
        }
        visited[x][y] = 0;
        return false;
    }
}
