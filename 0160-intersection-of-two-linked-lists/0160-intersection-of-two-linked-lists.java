/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        int count2 = 0;
        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while(curr1 != null){
            count1++;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            count2++;
            curr2 = curr2.next;
        }
        curr1 = headA;
        curr2 = headB;

        int d = Math.abs(count1 - count2);
        if(count1 > count2){
            for(int i=0 ; i<d ; i++){
                curr1 = curr1.next;
            }
        }
        else{
            for(int i=0 ; i<d ; i++){
                curr2 = curr2.next;
            }
        }
        while(curr1 != null && curr2 != null){
            if(curr1 == curr2){
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;

    }
}