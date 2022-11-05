/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
         
        // ***** Recursive Solution****
//         List<Integer> list=new ArrayList<>();
        
        
//         dfs(root,list);
//         return list;
//     }
    
//     void dfs(Node root, List<Integer> list)
//     {
//         if(root==null) return ;
        
//         list.add(root.val);
        
//         for(Node child : root.children)
//         {
//             dfs(child,list);
//         }
        
        //// Iterative Solution
        
        List<Integer> list=new ArrayList<>();
        
          if(root==null) return list;
        
         Stack<Node> st =new Stack<>();
        
        st.push(root);
        
        while(st.size()>0)
        {
            root = st.pop();
            
            list.add(root.val);
            
            for(int i=root.children.size()-1;i>=0;i--)
            {
                Node child = root.children.get(i);
                
                st.push(child);
            }
        }
        
        return list;
    }
}