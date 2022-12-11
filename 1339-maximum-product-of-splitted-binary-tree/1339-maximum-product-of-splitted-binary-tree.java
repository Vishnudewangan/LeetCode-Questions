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
    
   long sum;
   long mx;
    public int maxProduct(TreeNode root) {
        sum= 0;
        mx=0;
        dfs(root);
        product(root);
        
        return (int)(mx % (int)(1e9+7));
        
    }
   void dfs(TreeNode root)
    {
        if(root==null) return ;
        
        sum+=(long)root.val;
        
        dfs(root.left);
        dfs(root.right);
    }
    
   long product(TreeNode root)
    {
        if(root==null) return 0;
        
        long l = product(root.left);
        long r = product(root.right);
        
        mx = Math.max( mx , (l+r+root.val) * (sum- l-r-root.val));
        
        return l+r+root.val;
    }
}