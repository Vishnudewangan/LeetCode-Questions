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
     ListNode left;
     boolean isPal;
     int count;
    int size;
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        left = head;
        count=1;
        size= size(head);
        isPal = true;
        
        helper(head);
        
        return isPal;
    }
    
    void helper(ListNode head)
    {
        if(head==null) return;
        
        helper(head.next);
        if(count<=size/2)
        {
            if(left.val !=head.val)
            {
                isPal = false;
            }
            left = left.next;
            count++;
        }
    }
    
    int size(ListNode head)
    {
        if(head==null) return 0;
        
        int cnt=0;
        
        ListNode curr= head;
        
        while(curr!=null)
        {
            curr= curr.next;
            cnt++;
        }
        
        return cnt;
    }
}