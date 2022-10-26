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
         int state;
         TreeNode node;
         
         Pair(int state , TreeNode node)
         {
             this.state= state;
             this.node =node;
         }
     }
    // state 0 -> pre, 1 -> in , 2 -> post
    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        if(root==null) return post;
        Stack<Pair> st =new Stack<>();
        
        st.push(new Pair(0,root));
        
        while(st.size()>0)
        {
            
            
            if(st.peek().state==0)
            {
                st.peek().state++;
                
                pre.add(st.peek().node.val);
                
                if(st.peek().node.left!=null)
                {
                    st.push(new Pair(0,st.peek().node.left));
                }
                
            }
            else if(st.peek().state==1)
            {
                st.peek().state++;
                in.add(st.peek().node.val);
                
                if(st.peek().node.right!=null)
                {
                    st.push(new Pair(0,st.peek().node.right));
                }
            }
            else if(st.peek().state==2)
            {
                post.add(st.peek().node.val);
                st.pop();
            }
        }
        
        return post;
    }
}