class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0;
        int high = people.length - 1;
        int[] saved = new int[people.length];
        int boatCount = 0;
        while(low < high) {
            int weight = people[low] + people[high];
            if(weight <= limit) {
                saved[low] = 1;
                saved[high] = 1;
                boatCount++;
                low++;
                high--;
            }
            else {
                high--;
            }
        }
        for(int i=0; i < people.length; i++) {
            if(saved[i] < 1) {
                boatCount++;
            }
        }
        return boatCount;
    }
}