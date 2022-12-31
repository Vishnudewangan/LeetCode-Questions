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
class FindElements {

    
    TreeNode Root;
    public FindElements(TreeNode root) {
         
        if(root!=null)root.val=0;
         makeTree(root);
        
         this.Root= root;
        
    }
    
    
    
    public boolean find(int target) {
        
        return findHelper(Root,target);
    }
    private boolean findHelper(TreeNode root,int target)
    {
        if(root==null) return false;
        
        if(root.val == target) return true;
        
        boolean lf = findHelper(root.left, target);
        if(lf==true) return true;
        
        boolean rf = findHelper(root.right,target);
        if(rf == true) return true;
        
        return false;
    }
    private void makeTree(TreeNode root)
    {
      if(root==null) return ;
        
        if(root.left!=null) root.left.val = 2*root.val+1;
        if(root.right!=null) root.right.val = 2*root.val+2;
        
         makeTree(root.left);
         makeTree(root.right);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */