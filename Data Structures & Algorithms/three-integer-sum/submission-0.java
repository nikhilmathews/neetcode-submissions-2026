class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Pair<Integer, Integer>>> sumToPair = new HashMap();
        Set<List<Integer>> triplets = new HashSet();
        
        for(int i=0; i < nums.length; i++) {
            for(int j=i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if(!sumToPair.containsKey(sum)) {
                    sumToPair.put(sum, new ArrayList());
                }
                sumToPair.get(sum).add(new Pair(i, j));
            }
        }
        for(int i=0; i < nums.length; i++) {
            int complement = -1 * nums[i];
            if(sumToPair.containsKey(complement)) {
                List<Pair<Integer, Integer>> pairs = sumToPair.get(complement);
                for(Pair<Integer, Integer> pair : pairs) {
                    if(pair.getKey() > i && pair.getValue() > i) {
                        List<Integer> triplet = new ArrayList();
                        triplet.add(nums[i]);
                        triplet.add(nums[pair.getKey()]);
                        triplet.add(nums[pair.getValue()]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList();
        for(List<Integer> trip : triplets) {
            result.add(trip);
        }
        return result;
    }
}
