class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles.length;
        for(int pile : piles) {
            high = Math.max(high, pile);
        }
        while(low < high) {
            int mid = (low + high) / 2;
            if(canFinishPile(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canFinishPile(int[] piles, int hours, int eatingRate) {
        for(int i=0; i < piles.length; i++) {
            hours -= Math.ceil((double) piles[i] / eatingRate);
        }
        return hours >= 0;
    }
}
