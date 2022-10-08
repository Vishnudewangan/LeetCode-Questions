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
        if(head==null || head.next==null  ) return head;
        int size= size(head);
        
        k=k%size;
        
        if(k==0) return head;
        ListNode fullReversedHead = reverse(head);
        
        ListNode curr = fullReversedHead;
        
        while(k>1 && curr.next!=null)
        {
            k--;
            curr= curr.next;
        }
        
        ListNode secondK= curr.next;
        curr.next=null;
        
        ListNode firstK = fullReversedHead;
        
        ListNode part1= reverse(firstK);
        ListNode part2 = reverse(secondK);
        
        ListNode tempHeadp1= part1;
        
        while(tempHeadp1.next!=null)
        {
            tempHeadp1 = tempHeadp1.next;
        }
        
        tempHeadp1.next = part2;
        
        return part1;
        
    }
    ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        
        ListNode curr = head;
        
        while(curr!=null)
        {
            ListNode currKaNext = curr.next;
            curr.next = prev;
            prev= curr;
            curr = currKaNext;
        }
        return prev;
    }
    
    int size(ListNode head)
    {
        int count=0;
        
        while(head!=null)
        {
            count++;
            head= head.next;
        }
        return count;
    }
}