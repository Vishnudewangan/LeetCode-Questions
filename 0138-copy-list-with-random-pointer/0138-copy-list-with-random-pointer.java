/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
          Node th = new Node(-1);
          Node dt = th;
        
        HashMap<Node,Node> map =new HashMap<>(); /// old node vs new Node
        
        
        Node curr= head;
        
        while(curr!=null)
        {
            Node node = new Node(curr.val);
            
            dt.next = node;
            
            map.put(curr,node);
            
            dt = dt.next;
            curr = curr.next;
        }
        
         curr= head;
        
        Node ans= th.next;
        
        while(curr!=null)
        {
            ans.random = curr.random==null ? null : map.get(curr.random);
            curr = curr.next;
            ans = ans.next;
        }
        
        return th.next;
        
        
    }
}