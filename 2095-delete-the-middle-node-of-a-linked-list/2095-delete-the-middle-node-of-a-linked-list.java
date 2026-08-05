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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next == null){
            return null;
        }

        ListNode slow = head, fast = head;
        ListNode prev = new ListNode(0);
        prev.next = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
           
        }
        prev.next = slow.next;

        return head;
    }
}