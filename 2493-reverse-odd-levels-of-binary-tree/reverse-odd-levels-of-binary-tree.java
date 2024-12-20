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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return root;
        List<List<Integer>> list =new ArrayList<>();
        
        Queue<TreeNode> que= new ArrayDeque<>();
        
        que.add(root);
         
        int lev = 0;
        while(que.size()>0)
        {
            int size = que.size();
            
            List<Integer> temp = new ArrayList<>();
            
            for(int i=0;i<size;i++)
            {
                TreeNode rem = que.remove();
                
                temp.add(rem.val);
                
                if(rem.left!=null) que.add(rem.left);
                if(rem.right!=null) que.add(rem.right);
            }
            
            if(lev%2==1)
            {
                Collections.reverse(temp);
            }
            
            list.add(temp);
            lev++;
        }
        
        
        lev = 0;
        
        que.add(root);
        
        
        while(que.size()>0)
        {
            int size= que.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode rem = que.remove();
                
                rem.val = list.get(lev).get(i);
                
                if(rem.left!=null) que.add(rem.left);
                if(rem.right!=null) que.add(rem.right);
            }
            lev++;
        }
        
        
        return root;
    }
}