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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode unreversedPrev = dummy;
        ListNode curr = head;
        for(int i=1; i < left; i++) {
            unreversedPrev = curr;
            curr = curr.next;
        }
        ListNode endReversed = curr;
        ListNode tempNext;
        ListNode prev = null;
        for(int i=left; i <= right; i++) {
            tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        endReversed.next = curr;
        unreversedPrev.next = prev;
        return dummy.next;
    }
}