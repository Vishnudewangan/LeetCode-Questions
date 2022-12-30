class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] vis =new boolean[graph.length];
        List<List<Integer>> ans =new ArrayList<>(); 
        List<Integer> temp =new ArrayList<>();
        dfs(0,graph.length-1,graph,vis,temp,ans);
        
        return ans;
    }
    void dfs(int src, int dest , int[][] graph, boolean[] vis, List<Integer> temp,List<List<Integer>> ans)
    {  
       
        vis[src] = true;
        temp.add(src);
        if(src==dest)
        {
            ans.add(new ArrayList<>(temp));
           
        }
         for(int nbr : graph[src])
         {
             if(vis[nbr]==false)
             {
                 
                 dfs(nbr,dest,graph,vis,temp,ans);
             }
         }
         temp.remove(temp.size()-1);
        vis[src] = false;
    }
}