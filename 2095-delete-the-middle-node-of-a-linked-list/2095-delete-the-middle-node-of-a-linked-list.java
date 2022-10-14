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
        
        ListNode[] midAndmidPrev = mid(head);
        ListNode mid = midAndmidPrev[0];
        ListNode midPrev = midAndmidPrev[1];
        ListNode midnext = mid.next;
        
//         ListNode curr=head;
        
// //         while(curr.next!=mid)
// //         {
// //             curr =curr.next;
// //         }
        
        midPrev.next=midnext;
        
        return head;
    }
    
    ListNode[] mid(ListNode head)
    {   ListNode midPrev=null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {    midPrev=slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        return new ListNode[]{slow,midPrev};
    }
}