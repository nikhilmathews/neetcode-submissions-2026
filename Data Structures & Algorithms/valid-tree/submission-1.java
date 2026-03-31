class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacency = new HashMap();
        for(int[] edge : edges) {
            if(!adjacency.containsKey(edge[0])) {
                adjacency.put(edge[0], new ArrayList());
            }
            adjacency.get(edge[0]).add(edge[1]);

            if(!adjacency.containsKey(edge[1])) {
                adjacency.put(edge[1], new ArrayList());
            }
            adjacency.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet();
        return !containsCycle(0, -1, adjacency, seen) && seen.size() == n;
    }

    private boolean containsCycle(int node, int parent, Map<Integer, List<Integer>> adjacency, Set<Integer> seen) {
        if(seen.contains(node)) {
            return true;
        }
        seen.add(node);
        List<Integer> neighbors = adjacency.getOrDefault(node, new ArrayList());
        for(Integer neighbor : neighbors) {
            if(neighbor != parent && containsCycle(neighbor, node, adjacency, seen)) {
                return true;
            }
        }
        return false;
    }
}
