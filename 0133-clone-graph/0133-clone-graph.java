/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
         if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        
        Queue<Node> que =new ArrayDeque<>();
        
           que.add(node);
     
         map.put(node,new Node(node.val,new ArrayList<>()));
        
        while(que.size()>0)
        {
            Node rem = que.remove();
          
            
            
            for(Node n : rem.neighbors)
            {
                 if(map.containsKey(n)==false)
                 {   map.put(n, new Node(n.val,new ArrayList<>()));
                     que.add(n);
                     
                 }
                 
                     map.get(rem).neighbors.add(map.get(n));
                
            }

            
          }
        
        return map.get(node);
        
        
    }
}