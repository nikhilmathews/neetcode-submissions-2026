class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        for(int stone : stones) {
            maxHeap.add(stone);
        }
        while(maxHeap.size() > 1) {
            Integer diff = maxHeap.poll() - maxHeap.poll();
            if(diff > 0) {
                maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
