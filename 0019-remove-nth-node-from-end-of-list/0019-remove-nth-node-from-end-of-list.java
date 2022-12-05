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
        
        int cnt=1;
        
        ListNode revHead = reverse(head);
        
        if(n==1)
        {
            head = revHead.next;
            return reverse(head);
        }
        else
        {
             ListNode revPrev = revHead;
        
            while(cnt < n-1)
            {
                cnt++;
                revPrev=revPrev.next;
            }

            revPrev.next=revPrev.next.next;

            return reverse(revHead);
            
        }
       
        
    }
    
    ListNode reverse(ListNode head)
    {
        ListNode curr= head;
        ListNode prev = null;
        
        while(curr!=null)
        {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr =currNext;
        }
        return prev;
    }
}