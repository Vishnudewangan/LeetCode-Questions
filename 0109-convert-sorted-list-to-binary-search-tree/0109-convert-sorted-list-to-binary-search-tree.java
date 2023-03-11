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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null) return null;
        
        if(head.next==null) return new TreeNode(head.val);
        
        ListNode[] arr =mid(head);
        ListNode left= arr[0];
        ListNode mid = arr[1];
        ListNode right = arr[2];
        
        TreeNode node = new TreeNode(mid.val);
        
        node.left= sortedListToBST(left);
        node.right = sortedListToBST(right);
        
        return node;
    }
    
   ListNode[] mid(ListNode head)
    {
        if(head==null) return null;
        
        ListNode slow =head;
        ListNode curr= null;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {   curr = slow;
            slow= slow.next;
            fast = fast.next.next;
            
           
        }
        
        curr.next=null;
        
        ListNode right = slow.next;
        slow.next=null;
        
        return new ListNode[]{head,slow,right};
    }
}