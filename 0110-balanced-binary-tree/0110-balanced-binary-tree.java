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
    
    boolean isBalance ;
    public boolean isBalanced(TreeNode root) {
        
        isBalance = true;
        
        height(root);
        
        return isBalance;
    }
    
    int height(TreeNode root)
    {
        if(root==null) return -1;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        int bf = Math.abs(lh-rh);
        
        if(bf>=2)
        {
            isBalance = false;
        }
        
        return Math.max(lh,rh)+1;
    }
}