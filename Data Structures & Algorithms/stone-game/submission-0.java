class Solution {
    public boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, piles.length - 1, 0, 0);
    }

    private boolean stoneGame(int[] piles, int start, int end, int aliceCount, int bobCount) {
        if(start > end) {
            return aliceCount > bobCount;
        }
        int firstStone = piles[start];
        int endStone = piles[end];
        if((end - start) % 2 == 0) {
            return stoneGame(piles, start + 1, end, aliceCount, bobCount + firstStone) ||
            stoneGame(piles, start, end - 1, aliceCount, bobCount + endStone);
        }
        return stoneGame(piles, start + 1, end, aliceCount + firstStone, bobCount) ||
            stoneGame(piles, start, end - 1, aliceCount + endStone, bobCount);
    }
}