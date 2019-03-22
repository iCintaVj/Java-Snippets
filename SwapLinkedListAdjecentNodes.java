//this function returns the linked list  adjecent swapped 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head.next;
        head.next=temp.next;
        temp.next=head;
        head.next=swapPairs(head.next);
        return temp;
    }
}
