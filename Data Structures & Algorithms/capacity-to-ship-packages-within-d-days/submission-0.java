class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int totalWeight = 0;
        for(int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int low = maxWeight;
        int high = totalWeight;
        int minWeightCapacity = totalWeight;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(canShipWithinDays(weights, days, mid)) {
                high = mid - 1;
                minWeightCapacity = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return minWeightCapacity;
    }

    private boolean canShipWithinDays(int[] weights, int days, int dailyCapacity) {
        int totalDailyWeight = 0;
        int i=0;
        while(i < weights.length) {
            if(totalDailyWeight + weights[i] > dailyCapacity) {
                days--;
                totalDailyWeight = weights[i];
            }
            else {
                totalDailyWeight += weights[i];
            }
            if(days == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}