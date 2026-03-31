class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }
    }

    private void bfs(int[][] grid, int x, int y) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Pair<Integer, Integer> pair = new Pair(x, y);
        Queue<Pair<Integer, Integer>> bfsQ = new ArrayDeque();
        bfsQ.offer(pair); 
        Set<Pair<Integer, Integer>> seen = new HashSet();
        int level = 0;
        while(!bfsQ.isEmpty()) {
            int levelSize = bfsQ.size();
            for(int i=0; i < levelSize; i++) {
                Pair<Integer, Integer> curr = bfsQ.poll();
                if(!seen.contains(curr)) {
                    seen.add(curr);
                    int currX = curr.getKey();
                    int currY = curr.getValue();
                    grid[currX][currY] = Math.min(grid[currX][currY], level);
                    for(int[] dir : directions) {
                        int nextX = currX + dir[0];
                        int nextY = currY + dir[1];
                        if(nextX >= 0 && nextX < grid.length && nextY >= 0 && 
                        nextY < grid[0].length && grid[nextX][nextY] > 0) {
                            bfsQ.offer(new Pair(nextX, nextY));
                        }
                    }
                }
            }
            level++;
        }
    }
}
