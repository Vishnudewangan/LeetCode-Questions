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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> que = new ArrayDeque<>();

        que.add(root);

        while(que.size() > 0)
        {
            int size = que.size();

            for(int i=0;i<size;i++)
            {   
                TreeNode rem = que.remove();

                if(i == size - 1){
                    ans.add(rem.val);
                }

                if(rem.left != null) que.add(rem.left);
                if(rem.right != null) que.add(rem.right);
            }
        }
        return ans;
    }
}