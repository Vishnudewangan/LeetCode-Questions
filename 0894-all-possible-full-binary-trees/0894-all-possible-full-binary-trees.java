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
     HashMap<Integer,List<TreeNode>> memo=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!memo.containsKey(n))
        {
            List<TreeNode> ans=new ArrayList<>();
        if(n==1)
        {
            TreeNode broot=new TreeNode(0);
            
            
            ans.add(broot);
            return ans;
        }
        else if(n%2==1)
        {
       
            for(int i=0;i<n;i++)
            {
               
                
                
                for(TreeNode left : allPossibleFBT(i))
                {
                    for(TreeNode right : allPossibleFBT(n-1-i))
                    {
                        TreeNode bns =new TreeNode(0);
                        bns.left=left;
                        bns.right = right;
                        ans.add(bns);
                    }
                }
            }
            
        }
            memo.put(n,ans);
        
       
        
    }
        
        
        
        return memo.get(n);
  }
}