/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> reverseStack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            reverseStack.push(curr);
            curr = curr.next;
        }
        ListNode dummyHead = new ListNode();
        curr = dummyHead;
        while(!reverseStack.isEmpty()) {
            curr.next = reverseStack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return dummyHead.next;
    }
}
