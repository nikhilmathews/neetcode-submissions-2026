class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] canFlowPacific = new int[heights.length][heights[0].length];
        int[][] canFlowAtlantic = new int[heights.length][heights[0].length];
        for(int i=0; i < heights.length; i++) {
            for(int j=0; j < heights[0].length; j++) {
                if(i == 0) {
                    canFlowPacific[i][j] = 1;
                }
                if(i == heights.length - 1) {
                    canFlowAtlantic[i][j] = 1;
                }
                if(j == 0) {
                    canFlowPacific[i][j] = 1;
                }
                if(j == heights[0].length - 1) {
                    canFlowAtlantic[i][j] = 1;
                }
            }
        }
        int[][] seenPacific = new int[heights.length][heights[0].length];
        int[][] seenAtlantic = new int[heights.length][heights[0].length];
        for(int i=0; i < heights.length; i++) {
            for(int j=0; j < heights[0].length; j++) {
                if(canFlowPacific[i][j] == 1) {
                    dfs(heights, i, j, seenPacific, canFlowPacific);
                }
                if(canFlowAtlantic[i][j] == 1) {
                    dfs(heights, i, j, seenAtlantic, canFlowAtlantic);
                }
            }
        }
        List<List<Integer>> canFlowBoth = new ArrayList();
        for(int i=0; i < heights.length; i++) {
            for(int j=0; j < heights[0].length; j++) {
                if(canFlowPacific[i][j] == 1 && canFlowAtlantic[i][j] == 1) {
                    List<Integer> coord = new ArrayList();
                    coord.add(i);
                    coord.add(j);
                    canFlowBoth.add(coord);
                }
            }
        }
        return canFlowBoth;
    }

    private void dfs(int[][] heights, int x, int y, int[][] seen, int[][] canFlowOcean) {
        seen[x][y] = 1;
        canFlowOcean[x][y] = 1;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for(int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if(nextX < 0 || nextY < 0 || nextX >= heights.length || nextY >= heights[0].length 
            || seen[nextX][nextY] == 1 || heights[x][y] > heights[nextX][nextY]) {
                continue;
            }
            else {
                dfs(heights, nextX, nextY, seen, canFlowOcean);
            }
        }
    }
}
