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
        helper(root,osum,"");
        
        return osum[0];
    }
    
    void helper(TreeNode root,int[] osum,String sum)
    {
        if(root==null) return;
        
         sum+=root.val;
        
        if(root.left==null && root.right==null)
        {
           osum[0]+=Integer.parseInt(sum);
        }
        
        
        helper(root.left, osum,sum);
        helper(root.right,osum,sum);
        
    }
}