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
    public ListNode reverseKGroup(ListNode head, int k) {
       
        
        int t =k;
        
        ListNode prev=head;
        int len =0;
        
        while(prev!=null)
        {
            len++;
            prev=prev.next;
        }
        
        if(len<k) return head;
        else prev= null;
        
        ListNode curr= head;
        
        
        while(t-->0)
        {
            ListNode next=curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
            
        }
        
        head.next= reverseKGroup(curr,k);
        
        return prev;
       
  
    }
}