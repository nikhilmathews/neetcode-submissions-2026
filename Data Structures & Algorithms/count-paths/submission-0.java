class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return uniquePaths(grid, 0, 0);
    }
    private int uniquePaths(int[][] grid, int x, int y) {
        if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0) {
            return 0;
        }
        if(x == grid.length - 1 && y == grid[0].length - 1) {
            return 1;
        }
        if(grid[x][y] > 0) {
            return grid[x][y];
        }
        grid[x][y] = uniquePaths(grid, x + 1, y) + uniquePaths(grid, x, y + 1);
        return grid[x][y];
    }
}
