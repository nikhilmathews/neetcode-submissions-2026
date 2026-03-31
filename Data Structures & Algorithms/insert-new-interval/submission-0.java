class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> insertedIntervals = new ArrayList();
        int i=0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            insertedIntervals.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        insertedIntervals.add(newInterval);
        while(i < intervals.length) {
            insertedIntervals.add(intervals[i]);
            i++;
        }
        int[][] inserted = new int[insertedIntervals.size()][2];
        for(int j=0; j < insertedIntervals.size(); j++) {
            inserted[j] = insertedIntervals.get(j);
        }
        return inserted;
    }
}
