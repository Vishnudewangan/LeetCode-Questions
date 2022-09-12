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
           String ans;
    public String smallestFromLeaf(TreeNode root) {
        
         ans="~";
        
        helper(root, new StringBuilder());
        
        return ans;
    }
    
    void helper(TreeNode root, StringBuilder sb)
    {
        if(root==null) return;
        
        sb.append((char)(root.val+'a'));
        
        if(root.left==null && root.right==null)
        {
            
            String s=sb.reverse().toString();
            sb.reverse();
            
            if(s.compareTo(ans) < 0)
            {
                ans= s;
            }
            
        }
        
        helper(root.left, sb);
        helper(root.right,sb);
        
        sb.deleteCharAt(sb.length()-1);
    }
}