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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode head = new ListNode();
        ListNode index = head;
        while(curr1 != null && curr2 != null) {
            if(curr1.val < curr2.val) {
                index.next = curr1;
                curr1 = curr1.next;
            }
            else {
                index.next = curr2;
                curr2 = curr2.next;
            }
            index = index.next;
        }
        if(curr1 != null) {
            index.next = curr1;
        }
        else {
            index.next = curr2;
        }
        return head.next;
    }
}