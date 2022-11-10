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
    public int pseudoPalindromicPaths (TreeNode root) {
        
        int[] freq =new int[10];
        
        int[] cnt= new int[1];
        
        helper(root,freq,cnt);
        return cnt[0];
    }
    void helper(TreeNode root,int[] freq, int[] cnt)
    {
        if(root==null) return;
        
        freq[root.val] ++;
        
        if(root.left==null && root.right==null)
        {
           int count=0;
            
            for(int i=0;i<10;i++)
            {
                if(freq[i]%2==1)
                {
                    count++;
                }
            }
            
            if(count<2)
            {
                cnt[0]++;
            }
            
            
        }
        
        helper(root.left,freq,cnt);
        helper(root.right,freq,cnt);
        
        freq[root.val]--;
        
    }
}