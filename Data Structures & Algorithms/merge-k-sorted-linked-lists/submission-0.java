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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(true) {
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;
            for(int i=0; i < lists.length; i++) {
                ListNode possible = lists[i];
                if(possible != null && possible.val < minVal) {
                    minIndex = i;
                    minVal = possible.val;
                }
            }
            if(minIndex < 0) {
                break;
            }
            curr.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
