/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> seen = new HashMap();
        return copyRandomList(head, seen);
    }

    private Node copyRandomList(Node curr, Map<Node, Node> seen) {
        if(curr == null) {
            return null;
        }
        if(seen.containsKey(curr)) {
            return seen.get(curr);
        }
        Node clone = new Node(curr.val);
        seen.put(curr, clone);
        clone.next = copyRandomList(curr.next, seen);
        clone.random = copyRandomList(curr.random, seen);
        return clone;
    }
}
