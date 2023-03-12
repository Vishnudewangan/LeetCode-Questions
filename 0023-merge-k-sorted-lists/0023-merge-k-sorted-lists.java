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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0) return null;
        
        return mergeKLists(lists,0,lists.length-1);
    }
    ListNode mergeKLists(ListNode[] lists , int si, int ei)
    {
        if(si==ei) return lists[si];
         
        int mid = (si+ei)/2;
        
        return mergeTwoLists(mergeKLists(lists,si,mid),mergeKLists(lists,mid+1,ei));
    }
    
    ListNode mergeTwoLists(ListNode list1 , ListNode list2)
    {
        if(list1==null && list2==null) return null;
        
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        ListNode c1 = list1;
        ListNode c2 = list2;
        
        while(c1!=null && c2!=null)
        {
            if(c1.val <= c2.val)
            {
                prev.next =c1;
                c1 = c1.next;
            }
            else
            {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        
        prev.next = c1!=null ? c1 : c2;
        
        return dummy.next;
    }
}