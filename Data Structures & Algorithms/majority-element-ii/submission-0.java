class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> elementCount = new HashMap();
        for(int num : nums) {
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList();
        for(int element : elementCount.keySet()) {
            if(elementCount.get(element) > nums.length / 3) {
                res.add(element);
            }
        }
        return res;
    }
}