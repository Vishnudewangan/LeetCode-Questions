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
    
      HashMap<Integer,List<TreeNode>> map =new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        
       return helper(n);
        
        
    }
    
    List<TreeNode> helper(int n)
    {
        if(n%2==0)
        {
            return new ArrayList<>();
        }
        
        if(n==1)
        {
            List<TreeNode> bres =new ArrayList<>();
            
            TreeNode broot =new TreeNode(0);
            
            bres.add(broot);
          
            return bres;
        }
        
        if(map.containsKey(n)) return map.get(n);
        
        List<TreeNode> res =new ArrayList<>();
        
        for(int i=1;i<n;i=i+2)
        {
            for(TreeNode left : helper(i))
            {
                for(TreeNode right : helper(n-i-1))
                {
                    TreeNode root  =new TreeNode(0);
                    
                    root.left = left;
                    root.right = right;
                    
                    res.add(root);
                }
            }
        }
        
        map.put(n,res);
        
        return map.get(n);
    }
}