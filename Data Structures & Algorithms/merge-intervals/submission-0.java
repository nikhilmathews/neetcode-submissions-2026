class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> mergedIntervals = new ArrayList();
        mergedIntervals.add(intervals[0]);
        for(int i=1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = mergedIntervals.get(mergedIntervals.size() - 1);
            if(prev[1] < curr[0]) {
                mergedIntervals.add(curr);
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        int[][] mergedInt = new int[mergedIntervals.size()][2];
        for(int i=0; i < mergedIntervals.size(); i++) {
            mergedInt[i] = mergedIntervals.get(i);
        }
        return mergedInt;
    }
}
