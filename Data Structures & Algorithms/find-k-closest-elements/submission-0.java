class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> closestElements = new PriorityQueue<Integer>(
            (a, b) -> {
                int diff = Integer.compare(Math.abs(a - x), Math.abs(b - x));
                return diff == 0 ? Integer.compare(a, b) : diff;
            }
        );
        for(int num : arr) {
            closestElements.offer(num);
        }
        List<Integer> kClosestNums = new ArrayList();
        for(int i=0; i < k; i++) {
            kClosestNums.add(closestElements.poll());
        }
        Collections.sort(kClosestNums);
        return kClosestNums;
    }
}