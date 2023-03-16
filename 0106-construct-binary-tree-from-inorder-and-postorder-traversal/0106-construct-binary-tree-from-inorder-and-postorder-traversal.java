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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        
        map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        
       return createTree(inorder,postorder,0,n-1,0,n-1);
        
        
    }
    
    TreeNode createTree(int[] inorder,int[] postorder,int is,int ie,int ps,int pe)
    {
        
        
        if(ps> pe || is>ie) return null;
        
        int val= postorder[pe];
        
        TreeNode root=new TreeNode(val);
        
        int idx=map.get(val);
        
        int colse=idx-is;
        
        
         root.left= createTree(inorder,postorder,is,idx-1,ps,ps+colse-1);
         root.right= createTree(inorder,postorder,idx+1,ie,ps+colse,pe-1);
        
        
         return root;
    }
}