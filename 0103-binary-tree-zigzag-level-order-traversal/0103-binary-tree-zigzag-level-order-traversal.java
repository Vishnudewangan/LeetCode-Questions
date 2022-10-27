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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        if(root==null) return ans;
        
        
        Queue<TreeNode> que =new ArrayDeque<>();
        
        que.add(root);
        
        int lev=0;
        while(que.size()>0)
        {
            int size=que.size();
            List<Integer> temp = new ArrayList<>();
            
             for(int i=0;i<size;i++)
             {
                 TreeNode rem = que.remove();
                 
                 temp.add(rem.val);
                 
                 if(rem.left!=null)
                 {
                     que.add(rem.left);
                 }
                 
                 if(rem.right!=null)
                 {
                     que.add(rem.right);
                 }
             }
            
            if(lev % 2==0)
            {
                ans.add(temp);
            }
            else
            {
                Collections.reverse(temp);
                ans.add(temp);
            }
            lev++;
        }
        
        return ans;
    }
}