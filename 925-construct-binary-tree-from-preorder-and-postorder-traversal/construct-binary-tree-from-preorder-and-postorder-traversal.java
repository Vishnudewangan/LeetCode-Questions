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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n= preorder.length;

        return solve(preorder,postorder,0,n-1,0,n-1);
    }
    private TreeNode solve(int[] preorder,int[] postorder,int prs,int pre,int pos,int poe){
        if(prs > pre) return null;

        if(prs==pre) return new TreeNode(preorder[prs]);

        TreeNode node =new TreeNode(preorder[prs]);
        int val = preorder[prs+1];
        int idx = -1;
        for(int i=pos;i<=poe;i++)
        {
            if(postorder[i]==val)
            {
               idx = i;
               break;
            }
        }

        // count of left side element
        int colse = idx - pos + 1;

        node.left= solve(preorder,postorder,prs+1,prs+colse,pos,idx);
        node.right = solve(preorder,postorder,prs+colse+1,pre, idx+1,poe);
        return node;
    }
}