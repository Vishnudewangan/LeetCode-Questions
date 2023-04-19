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
    static class Pair
    {
        int lzzp;
        int rzzp;
        int mzzp;
        
        Pair(int lzzp,int rzzp,int mzzp)
        {
            this.lzzp=lzzp;
            this.rzzp=rzzp;
            this.mzzp=mzzp;
        }
    }
    public int longestZigZag(TreeNode root) {
        
        Pair rp =helper(root);
        
        return rp.mzzp;
        
    }
  Pair helper(TreeNode root)
  {
      if(root==null) return new Pair(-1,-1,0);
      
      
      Pair lp = helper(root.left);
      Pair rp = helper(root.right);
      
      int lzzp = 1 + lp.rzzp;
      int rzzp = 1+ rp.lzzp;
      int mzzp = max(lp.mzzp,rp.mzzp,lzzp,rzzp);
      
      return new Pair(lzzp,rzzp,mzzp);
  }
    
    int max(int...arr)
    {
        int max=Integer.MIN_VALUE;
        
        for(int val : arr)
        {
            max=Math.max(val,max);
        }
        
        return max;
    }
}