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
        
         // HashMap method
        
//           Node th = new Node(-1);
//           Node dt = th;
        
//         HashMap<Node,Node> map =new HashMap<>(); /// old node vs new Node
        
        
//         Node curr= head;
        
//         while(curr!=null)
//         {
//             Node node = new Node(curr.val);
            
//             dt.next = node;
            
//             map.put(curr,node);
            
//             dt = dt.next;
//             curr = curr.next;
//         }
        
//          curr= head;
        
//         Node ans= th.next;
        
//         while(curr!=null)
//         {
//             ans.random = curr.random==null ? null : map.get(curr.random);
//             curr = curr.next;
//             ans = ans.next;
//         }
        
//         return th.next;
        
        // O(1)
        
        if(head==null) return null;
        
        Node curr= head;
        
        while(curr!=null)
        {
            Node currNext = curr.next;
            
            Node nn= new Node(curr.val);
            
            curr.next= nn;
            nn.next = currNext;
            
            curr = currNext;
        }
        
        
        curr = head;
        
        while(curr!=null)
        {
            curr.next.random = curr.random==null ? null : curr.random.next;
            
            curr= curr.next.next;
        }        
        
        
        Node c1=head;
        Node ans= c1.next;
        Node c2 = c1.next;
        
        while(c1!=null && c2!=null)
        {
            Node n1= c2.next;
            Node n2 = n1!=null ? n1.next: null;
            
            c1.next = n1 ;
            c2.next= n2;
            
            c1=n1;
            c2=n2;
        }
        
        return ans;
        
    }
}