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
    public ListNode[] splitListToParts(ListNode head, int k) {
       
         int size= size(head);
        
        int noOfElementPerGroup = size/k;
        
        int firstNperKGroup= size%k;
         ListNode[] ans = new ListNode[k];
        
       
        ListNode curr =head;
        
        for(int i=0;i<k;i++)
        {
              ListNode root=curr;
            for(int j=0;j< noOfElementPerGroup + (i<firstNperKGroup ? 1: 0 ) -1 ; j++ )
            {
                if(curr !=null) curr =curr.next;
            }
            if(curr!=null)
            {
                ListNode prev=curr;
                curr =curr.next;
                prev.next = null;
            }
            ans[i]=root;
            
            
        }
        
        return ans;
        
    }
    
    public int size(ListNode head)
    {
        int count=0;
        
        while(head!=null)
        {
            count++;
            head = head.next;
        }
        
        return count;
    }
}