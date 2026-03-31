class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> bfsQ = new ArrayDeque();
        int minutes = 0;
        int freshFruits = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    bfsQ.offer(new Pair(i, j));
                }
                else if(grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }
        if (freshFruits == 0) return 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int[][] seen = new int[grid.length][grid[0].length];
        while(!bfsQ.isEmpty()) {
            int levelSpoiled = bfsQ.size();
            for(int i = 0; i < levelSpoiled; i++) {
                Pair<Integer, Integer> coord = bfsQ.poll();
                int x = coord.getKey();
                int y = coord.getValue();
                for(int[] dir : directions) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if(nextX >= 0 && nextX < grid.length && nextY >= 0 
                    && nextY < grid[0].length && seen[nextX][nextY] == 0
                    && grid[nextX][nextY] == 1) {
                        seen[nextX][nextY] = 1;
                        freshFruits--;
                        bfsQ.offer(new Pair(nextX, nextY));
                    }
                }
            }
            minutes++;
        }
        return freshFruits > 0 ? -1 : minutes - 1;
    }
}