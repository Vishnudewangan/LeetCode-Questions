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
    int diff;
    public int maxAncestorDiff(TreeNode root) {
       diff=0;
        
        helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return diff;
        
}
    
    void helper(TreeNode root,int maxAncestor,int minAncestor)
    {
        if(root==null) return;
        
        maxAncestor= Math.max(root.val, maxAncestor);
        minAncestor = Math.min(root.val,minAncestor);
        
        int maxdiff= Math.abs(root.val - maxAncestor);
        int mindiff= Math.abs(root.val - minAncestor);
        
         diff= Math.max(maxdiff,diff);
         diff= Math.max(mindiff,diff);
        
        
        // System.out.println(minAncestor+" "+maxAncestor+" "+root.val+" - "+diff);
        
        helper(root.left,maxAncestor,minAncestor);
        helper(root.right,maxAncestor,minAncestor);
    }
    
    
}    