class MedianFinder {
    PriorityQueue<Integer> botHalfHeap;
    PriorityQueue<Integer> topHalfHeap;

    public MedianFinder() {
        botHalfHeap = new PriorityQueue(Comparator.reverseOrder());
        topHalfHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if (botHalfHeap.isEmpty() || num < botHalfHeap.peek()) {
            botHalfHeap.offer(num);
        } else {
            topHalfHeap.offer(num);
        }
        rebalance(botHalfHeap, topHalfHeap);
    }

    private void rebalance(PriorityQueue<Integer> botHalfHeap, PriorityQueue<Integer> topHalfHeap) {
        while(topHalfHeap.size() > botHalfHeap.size() + 1) {
            botHalfHeap.offer(topHalfHeap.poll());
        }
        while(botHalfHeap.size() > topHalfHeap.size() + 1) {
            topHalfHeap.offer(botHalfHeap.poll());
        }
    }
    
    public double findMedian() {
        if(topHalfHeap.size() == botHalfHeap.size()) {
            return (double) (topHalfHeap.peek() + botHalfHeap.peek()) / 2;
        }
        else if(botHalfHeap.size() > topHalfHeap.size()) {
            return (double) botHalfHeap.peek();
        }
        return (double) topHalfHeap.peek();
    }
}
