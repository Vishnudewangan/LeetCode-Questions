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
    ListNode rLeft;
    public boolean isPalindrome(ListNode head) {
          rLeft = head;
        
          
         return  helper(head);
    }
    boolean helper(ListNode rRight)
    {
        if(rRight == null) return true;
        
        
        boolean res= helper(rRight.next);
        
        if(res==false)
           {
               return false;
           }
        else if(rLeft.val !=rRight.val)
        {
            return false;
        }
        else
        {
             rLeft= rLeft.next;
            return true;
        }
    }
}