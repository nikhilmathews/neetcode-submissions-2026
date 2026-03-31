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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now we're in the middle. Time to reverse the second half.
        ListNode prev = null;
        ListNode next;
        while(slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        ListNode reversed = prev;
        // Now finally stitch the two lists together.
        ListNode forward = head;
        while(forward != null && reversed != null) {
            next = forward.next;
            forward.next = reversed;
            ListNode reversedNext = reversed.next;
            reversed.next = next;
            forward = next;
            reversed = reversedNext;
        }
    }
}
