class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
           graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] vis =new boolean[n];
       
        return dfs(source,destination,graph,vis);
       
       
    }
    
    boolean dfs(int src, int dest,ArrayList<ArrayList<Integer>> graph,boolean[] vis)
    {   
        if(src==dest) return true;
        vis[src] = true;
        
        for(int nbr : graph.get(src))
        {
            if(vis[nbr]==false)
            {
                boolean reachedDest = dfs(nbr,dest,graph,vis);
                
                if(reachedDest==true)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}