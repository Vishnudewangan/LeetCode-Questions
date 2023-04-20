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
        TreeNode node;
        int num;
        
        Pair(TreeNode node, int num)
        {
            this.node=node;
            this.num=num;
        }
    }
   
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null ) return 0;
         int ans=0;
        
        Queue<Pair> que=new ArrayDeque<>();
        que.add(new Pair(root,0));
        
        int first=0, last=0;
        
        while(que.size()>0)
        {
            int count=que.size();
            
            int mmin=que.peek().num;
            
            for(int i=0;i<count; i++)
            { 
                
                
                Pair rem=que.remove();
                int curr_n=rem.num;
                
                if(i==0) first=curr_n;
                if(i==count-1) last=curr_n;
                
                if(rem.node.left!=null) que.add(new Pair(rem.node.left, curr_n*2+1));
                if(rem.node.right!=null) que.add(new Pair(rem.node.right, curr_n*2+2));
            }
            
            ans=Math.max(ans,last-first+1);
        }
        
        return ans;
        
        
        
    }
}