class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return uniquePathWithObstacles(obstacleGrid, 0, 0, memo);
    }

    private int uniquePathWithObstacles(int[][] obstacleGrid, int x, int y, int[][] memo) {
        if(x < 0 || y < 0 || x >= obstacleGrid.length || y >= obstacleGrid[0].length
         || obstacleGrid[x][y] == 1) {
            return 0;
        }
        if(x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return 1;
        }
        if(memo[x][y] > -1) {
            return memo[x][y];
        }
        memo[x][y] = uniquePathWithObstacles(obstacleGrid, x + 1, y, memo) + uniquePathWithObstacles(obstacleGrid, x, y + 1, memo);
        return memo[x][y];
    }
}