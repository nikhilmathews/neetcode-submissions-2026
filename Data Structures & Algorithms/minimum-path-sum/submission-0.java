class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minPathSum(grid, 0, 0, memo);
    }
    private int minPathSum(int[][] grid, int x, int y, int[][] memo) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        if(memo[x][y] > -1) {
            return memo[x][y];
        }
        memo[x][y] = grid[x][y] + Math.min(minPathSum(grid, x + 1, y, memo), minPathSum(grid, x, y + 1, memo));
        return memo[x][y];
    }
}