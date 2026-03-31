class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        List<Integer> maxElement = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        maxElement.add(maxHeap.peek());
        for(int i = k; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            maxHeap.remove(nums[i-k]);
            maxElement.add(maxHeap.peek());
        }
        
        int[] result = new int[maxElement.size()];
        for(int i=0; i < maxElement.size(); i++) {
            result[i] = maxElement.get(i);
        }
        return result;
    }
}
