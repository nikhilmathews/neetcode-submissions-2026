class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>>
        ((a, b) -> 
        Double.compare(
        Math.sqrt(Math.pow(b.getKey(), 2) + Math.pow(b.getValue(), 2)),
        Math.sqrt(Math.pow(a.getKey(), 2) + Math.pow(a.getValue(), 2))));

        for(int [] point : points) {
            Pair<Integer, Integer> currPoint = new Pair(point[0], point[1]);
            maxHeap.offer(currPoint);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ret = new int[k][2];
        for(int[] retPoint : ret) {
            Pair<Integer, Integer> point = maxHeap.poll();
            retPoint[0] = point.getKey();
            retPoint[1] = point.getValue();
        }
        return ret;
    }
}

