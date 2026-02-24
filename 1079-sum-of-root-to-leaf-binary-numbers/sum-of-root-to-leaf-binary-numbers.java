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
    public int sumRootToLeaf(TreeNode root) {
        
        if(root==null) return 0;
        int[] sum=new int[1];
        sum[0]=0;
        
        
        helper(root, sum, "");
        return sum[0];
        
        
    }
    
    void helper(TreeNode root, int[] sum,String psf)
    {    
        
        psf+=root.val;
        if(root.left==null && root.right==null)
        {
           int decimal =Integer.parseInt(psf, 2);
            
            sum[0]+=decimal;
        }
        
        if(root.left!=null) helper(root.left, sum,psf);
        if(root.right!=null ) helper(root.right,sum, psf);
            
    }
}