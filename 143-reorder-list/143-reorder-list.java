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
       int size;
    public void reorderList(ListNode head) {
        
        left=head;
        
        size= size(head);
        helper(head, 0);
        
        
        
    }
    void helper(ListNode right , int floor)
    {
       if(right==null) return ;
        
        
        helper(right.next,floor+1);
        
        if(floor > size/2)
        {
            ListNode temp = left.next;
            right.next= temp;
            left.next= right;
            left =temp;
        }
        else if(floor== size/2)
        {
            right.next=null;
        }
        
    }
    
    int size(ListNode head)
    {
        if(head==null) return 0;
        
        ListNode curr= head;
        int count=0;
        
        while(curr!=null)
        {
            curr=curr.next;
            count++;
        }
        return count;
    }
    
    
    
}