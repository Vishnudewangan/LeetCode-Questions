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
    public int pairSum(ListNode head) {
        
        ListNode mid = mid(head);
        
        ListNode second = mid.next;
        
        mid.next= null;
        
       
        
        ListNode revHead = reverse(second);
        
        int maxsum = Integer.MIN_VALUE;
        
        while(head!=null && revHead!=null)
        {
            int sum = head.val + revHead.val;
            
            maxsum =Math.max(maxsum,sum);
            
            head = head.next;
            revHead = revHead.next;
        }
        
        return maxsum;
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
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null)
        {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
           curr = currNext;
            
        }
        
        return prev;
    }
}