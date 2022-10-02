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
    public int sumNumbers(TreeNode root) {
        
        int[] osum= new int[1];
        helper(root,osum,0);
        
        return osum[0];
    }
    
    void helper(TreeNode root,int[] osum,int sum)
    {
        if(root==null) return;
        
         sum= sum*10 + root.val;
        
        if(root.left==null && root.right==null)
        {
           osum[0]+=sum;
        }
        
        
        helper(root.left, osum,sum);
        helper(root.right,osum,sum);
        
    }
}