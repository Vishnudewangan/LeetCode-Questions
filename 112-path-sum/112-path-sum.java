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
       int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root==null) return false;
        
        sum+=root.val;
        
        if(root.left==null && root.right==null && sum==targetSum)
        {
            return true;
        }
        
        boolean lb=hasPathSum(root.left,targetSum);
        boolean rb = hasPathSum(root.right,targetSum);
         
        sum-=root.val;
        if(lb|| rb) return true;
        
        
        return false;
        
    }
}