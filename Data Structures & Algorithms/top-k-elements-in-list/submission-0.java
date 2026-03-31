class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap();
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for(int num : frequencyMap.keySet()) {
            maxHeap.offer(new Pair(num, frequencyMap.get(num)));
        }
        for(int i=0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }
}
