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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null) return head;
         
         int size = size(head);
           k = k %size;
        if(k==0 || k==size) return head;
           
        
        
        // System.out.println(k +" " + size);
        
        ListNode firstHead = reverse(head);
        
        ListNode curr= firstHead;
        
        while(k>1)
        {
            curr = curr.next;
            k--;
        }
        
        ListNode secondHead = curr.next;
         
        curr.next= null;
        
        ListNode firstRev = reverse(firstHead);
        ListNode secondRev = reverse(secondHead);
        
       firstHead.next = secondRev;
        
        return firstRev;
        
        
    }
    
    ListNode reverse(ListNode head)
    {
         if(head == null || head.next==null) return head;
        
         ListNode prev = null;
         ListNode curr = head;
        
        while(curr!=null)
        {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = currNext;
        }
        
        return prev;
    }
    
    int size(ListNode head)
    {
        if(head==null ) return 0;
        
        int count =0;
        
        ListNode curr= head;
        
        while(curr!=null)
        {
            curr = curr.next;
            count++;
        }
        return count;
    }
}