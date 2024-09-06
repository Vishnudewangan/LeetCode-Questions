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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        ListNode curr = head;

        HashSet<Integer> set =new HashSet<>();
        for(int val : nums) set.add(val);

        while(curr!=null)
        {
            while(curr!=null && set.contains(curr.val)==true)
            {
                curr = curr.next;
            }

            prev.next = curr;
            prev = curr;
            if(curr!=null) curr = curr.next;
        }
        
        return dummyHead.next;
    }
}