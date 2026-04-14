class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
            (a, b) -> Integer.compare(frequencyMap.get(a), frequencyMap.get(b)));
        
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for(int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for(int i=0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
