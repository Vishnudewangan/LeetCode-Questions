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
        
        ListNode mid = mid(head);
        
        ListNode sh = mid.next;
        mid.next=null;
        
         sh = reverse(sh);
        
        ListNode head1=head;
        ListNode head2=sh;
        
        ListNode dummy = new ListNode(-1);
        ListNode dt = dummy;
        
        boolean flag = true;
        
        while(head1!=null || head2!=null)
        {
            if(flag==true)
            {
                dt.next=head1;
                head1=head1.next;
            }
            else
            {
                dt.next=head2;
                head2 = head2.next;
            }
            
            dt= dt.next;
            flag=!flag;
        }
        
        
    }
    
    ListNode mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        
        }
        return slow;
    }
    
    ListNode reverse(ListNode head)
    {
        ListNode curr= head;
        ListNode prev= null;
        
        while(curr!=null)
        {
            ListNode currNext= curr.next;
            curr.next = prev;
            prev = curr;
            curr= currNext;
        }
        
        return prev;
    }
}