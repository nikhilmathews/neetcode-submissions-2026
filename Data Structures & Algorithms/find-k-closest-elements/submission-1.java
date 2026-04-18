class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while(right - left + 1 > k) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);
            if(leftDiff > rightDiff) {
                left++;
            }
            else {
                right--;
            }
        }
        List<Integer> kClosestElements = new ArrayList();
        while(left <= right) {
            kClosestElements.add(arr[left]);
            left++;
        }
        return kClosestElements;
    }
}