class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> trustCount = new HashMap();
        Map<Integer, Integer> trustedCount = new HashMap();
        for(int i=0; i < trust.length; i++) {
            int[] t = trust[i];
            trustCount.put(t[0], trustCount.getOrDefault(t[0], 0) + 1);
            trustedCount.put(t[1], trustedCount.getOrDefault(t[1], 0) + 1);
        }
        for(int i=1; i <= n; i++) {
            if(trustCount.getOrDefault(i, 0) == 0 && trustedCount.getOrDefault(i, 0) == n - 1) {
                return i;
            }
        }
        return -1;
    }
}