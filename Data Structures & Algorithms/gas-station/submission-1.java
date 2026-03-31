class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i < gas.length; i++) {
            if(gas[i] >= cost[i] && canCompleteCircuit(gas, cost, gas[i] - cost[i], i, i + 1)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canCompleteCircuit(int[] gas, int[] cost, int tank, int startIndex, int currIndex) {
        if(currIndex >= gas.length) {
            currIndex = 0;
        }
        if(currIndex == startIndex) {
            return true;
        }
        tank += gas[currIndex];
        if(tank >= cost[currIndex]) {
            return canCompleteCircuit(gas, cost, tank - cost[currIndex], startIndex, currIndex + 1);
        }
        return false;
    }
}
