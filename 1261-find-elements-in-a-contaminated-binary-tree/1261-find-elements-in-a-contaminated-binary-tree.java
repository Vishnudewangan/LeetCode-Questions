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
      
    HashSet<Integer> seen =new HashSet<>();
    public FindElements(TreeNode root) {
        dfs(root,0);
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }
    
    void dfs(TreeNode root, int val)
    {
        if(root==null) return ;
        
        seen.add(val);
        root.val = val;
        
        dfs(root.left, val*2+1);
        dfs(root.right, val*2+2);
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */