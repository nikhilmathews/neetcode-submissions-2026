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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while(currL1 != null || currL2 != null) {
            curr.next = new ListNode();
            curr = curr.next;

            int currL1Val = 0;
            if(currL1 != null) {
                currL1Val = currL1.val;
                currL1 = currL1.next;
            }
            int currL2Val = 0;
            if(currL2 != null) {
                currL2Val = currL2.val;
                currL2 = currL2.next;
            }
            
            curr.val = currL1Val + currL2Val + carry;

            if(curr.val > 9) {
                carry = 1;
                curr.val %= 10;
            } else {
                carry = 0;
            }
        }
        if(carry > 0) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}
