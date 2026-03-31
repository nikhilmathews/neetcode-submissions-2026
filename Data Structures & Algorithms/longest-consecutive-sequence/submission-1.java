class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet();
        for(int num : nums) {
            seen.add(num);
        }
        int maxConsecutive = 0;
        for(int num : seen) {
            int count = 1;
            while(seen.contains(++num)) {
                count++;
            }
            maxConsecutive = Math.max(maxConsecutive, count);
        }
        return maxConsecutive;
    }
}
