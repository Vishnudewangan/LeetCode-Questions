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
      TreeNode prev;
       boolean isBST ;
    public boolean isValidBST(TreeNode root) {
        
        prev=null;
        isBST= true;
        
        helper(root);
        
        return isBST;
    }
    
    void helper(TreeNode root)
    {
        if(root==null) return;
        
        helper(root.left);
        
        if(prev!=null && prev.val >= root.val)
        {
            isBST=false;
        }
        
        prev= root;
        helper(root.right);
    }
}