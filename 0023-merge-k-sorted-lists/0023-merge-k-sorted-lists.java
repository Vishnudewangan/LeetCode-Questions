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
        
        if(lists==null || lists.length==0) return null;
        
        
        if(lists.length==1) return lists[0];
        
        if(lists.length==2)
        {
            return mergeTwoList(lists[0],lists[1]);
        }
        
       return mergeHelp(lists,0,lists.length-1);
    }
    
   ListNode mergeTwoList(ListNode list1 , ListNode list2)
    {
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        ListNode dummy = new ListNode(-1);
        
        ListNode dt = dummy;
        
        ListNode curr1=list1;
        ListNode curr2 = list2;
        
        while(curr1!=null && curr2!=null)
        {
          if(curr1.val < curr2.val )
          {
              dt.next= curr1;
              curr1 = curr1.next;
          }
          else
          {
              dt.next = curr2;
              curr2 = curr2.next;
          }
            
        dt = dt.next;
        }
        
        if(curr1!=null)
        {
            dt.next= curr1;
        }
        if(curr2!=null)
        {
            dt.next = curr2;
        }
        
        return dummy.next;
    }
    
    ListNode mergeHelp(ListNode[] lists, int start, int end)
    {
        
        if(start== end)
        {
            return lists[start];
        }
         int mid = (start+end)/2;
        
        ListNode left = mergeHelp(lists,start,mid);
        ListNode right = mergeHelp(lists,mid+1,end);
        
        return mergeTwoList(left,right);
    }
}