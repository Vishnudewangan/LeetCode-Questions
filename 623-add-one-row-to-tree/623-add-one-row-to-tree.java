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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1)
        {
            TreeNode newRoot= new TreeNode(val);
            
            newRoot.left= root;
            return newRoot;
        }
        
         helper(root, val, depth,1);
        
        return root;
                
    }
    
    void helper(TreeNode root, int val, int depth, int lev)
    {
        if(root==null) return ;
        
        
        if(depth-1 == lev)
        {
            TreeNode leftRoot= new TreeNode(val);
            TreeNode rightRoot = new TreeNode(val);
            
            TreeNode leftSubTree = root.left;
            TreeNode rightSubTree = root.right;
            
            leftRoot.left= leftSubTree;
            rightRoot.right = rightSubTree;
            
            root.left= leftRoot;
            root.right = rightRoot;
            
            return;
        }
        helper(root.left,val, depth,lev+1);
        helper(root.right,val,depth,lev+1);
    }
}