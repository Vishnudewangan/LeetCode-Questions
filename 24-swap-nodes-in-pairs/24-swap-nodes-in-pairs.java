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
    public ListNode swapPairs(ListNode A) {
         ListNode odd=new ListNode(-1);
        ListNode ot = odd;
        
        ListNode even = new ListNode(-1);
        ListNode et = even;
        
        
        boolean isOdd = true;
        
      ListNode curr=A;
      
      while(curr!=null)
      {
          if(isOdd)
          {
              ot.next= curr;
              ot = ot.next;
          }
          else
          {
              et.next= curr;
              et = et.next;
          }
           isOdd=!isOdd;
            curr=curr.next;
          
     }
     ot.next=null;
     et.next= null;
     
     
     ListNode ans = new ListNode(-1);
     ListNode at = ans;
     
     odd =odd.next;
     even =even.next;
     
     isOdd= false;
     
     while(odd!=null && even!=null)
     {
         if(isOdd==false  )
         {
             at.next= even;
             even =even.next;
         }
         else 
         {
             at.next = odd;
             odd=odd.next;
         }
         isOdd=!isOdd;
         at = at.next;
     }
     
     if(odd!=null)
     {
         at.next= odd;
     }
     
     if(even!=null) at.next=even;
     return ans.next;
    }
}