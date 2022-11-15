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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        
        if(lh == rh) return (int)Math.pow(2,lh)-1;
        
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    
    int leftHeight(TreeNode root)
    {
        if(root==null) return 0;
        
        return leftHeight(root.left)+1;
    }
    
    int rightHeight(TreeNode root)
    {
        if(root == null) return 0;
        
        return rightHeight(root.right)+1;
    }
}