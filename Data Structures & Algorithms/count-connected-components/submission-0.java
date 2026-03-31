class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacent = new ArrayList();
        for(int i=0; i < n; i++) {
            adjacent.add(new ArrayList());
        }
        for(int[] edge : edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        int componentCount = 0;
        Set<Integer> seen = new HashSet();
        for(int i=0; i < n; i++) {
            if(!seen.contains(i)) {
                componentCount++;
                search(i, adjacent, seen);
            }
        }
        if(seen.size() < n) {
            componentCount += n - seen.size();
        }
        return componentCount;
    }
    private void search(int node, List<List<Integer>> adjacent, Set<Integer> seen) {
        if(seen.contains(node)) {
            return;
        }
        seen.add(node);
        List<Integer> neighbors = adjacent.get(node);
        for(Integer neighbor : neighbors) {
            search(neighbor, adjacent, seen);
        }
    }
}
