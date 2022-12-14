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
     int n2n;
    public int maxPathSum(TreeNode root) {
        
        n2n= Integer.MIN_VALUE;
        
        helper(root);
        
        return n2n;
        
    }
    
    int helper(TreeNode root)
    {
        if(root==null) return 0;
        
        int l = helper(root.left);
        int r= helper(root.right);
        
        n2n= Math.max(n2n, l+r+root.val);
        
        int n2r = Math.max(l,r)+root.val;
        
        n2n =Math.max(n2n, Math.max(n2r,root.val));
        
        return Math.max(n2r,root.val);
    }
}