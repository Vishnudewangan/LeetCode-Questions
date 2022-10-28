//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis=new boolean[V];
        boolean[] visrec=new boolean[V];
        
        
        for(int i=0;i<V;i++)
        {      if(vis[i]==false)
               if(solve(adj, i, vis,visrec)==true)
              {
                return true;
               }
            
           
           
        }
        
        
        
        return false;
        
    }
    
    boolean solve(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, boolean[] visrec)
    {
        
       
        vis[src] = true;
        visrec[src] = true;
        
        
        for(int nbr : adj.get(src))
         {
                if(vis[nbr]==false)
                {
                    
                 boolean cycle = solve(adj,nbr, vis, visrec);
                 
                   if(cycle==true){
                        return true;
                   }
                }
                else if(visrec[nbr]==true)
                {
                    return true;
                }
            
         }
         
         
         
         
         visrec[src] = false;
         return false;
    }
}