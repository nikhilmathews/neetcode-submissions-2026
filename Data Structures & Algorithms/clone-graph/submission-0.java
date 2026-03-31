/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap());
    }

    private Node cloneGraph(Node node, Map<Node, Node> seen) {
        if(node == null) {
            return null;
        }
        if(seen.containsKey(node)) {
            return seen.get(node);
        }
        Node clone = new Node(node.val);
        seen.put(node, clone);
        List<Node> clonedNeighbors = new ArrayList();
        for(Node neighbor : node.neighbors) {
            clonedNeighbors.add(cloneGraph(neighbor, seen));
        }
        clone.neighbors = clonedNeighbors;
        return clone;
    }

}