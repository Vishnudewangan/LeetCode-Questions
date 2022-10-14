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
        if(head.next==null) return null;
        
        ListNode mid = mid(head);
        ListNode midnext = mid.next;
        
        ListNode curr=head;
        
        while(curr.next!=mid)
        {
            curr =curr.next;
        }
        
        
    
        
        curr.next=midnext;
        
        return head;
    }
    
    ListNode mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}