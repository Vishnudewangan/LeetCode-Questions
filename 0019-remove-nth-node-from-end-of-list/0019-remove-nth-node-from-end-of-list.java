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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size=size(head);
        
        
        int forward = size - n;
        
       
        
        if(forward == 0)
        {
            head = head.next;
            
            return head;
        }
        
        int count= 1;
        
        ListNode curr = head;
        while(count < forward)
        {
            count++;
            curr=curr.next;
        }
        
        
        curr.next = curr.next.next;;
        
        return head;
    
    }
    
    int size(ListNode head)
    {
        if(head==null) return 0;
        
        int count =0;
        ListNode curr= head;
        while(curr!=null)
        {
            count++;
           curr = curr.next;
        }
        
        return count;
    }
}