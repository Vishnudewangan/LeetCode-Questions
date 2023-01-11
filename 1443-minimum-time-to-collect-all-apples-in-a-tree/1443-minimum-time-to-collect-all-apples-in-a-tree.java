class Solution {
    static class Pair 
    {
        int time;
        boolean isApplePresent;
        
        Pair(int time, boolean isApplePresent)
        {
            this.time = time;
            this.isApplePresent= isApplePresent;
        }
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
       
        return dfs(0,graph,-1,hasApple).time;
        
       
    }
    
    Pair dfs(int src,ArrayList<ArrayList<Integer>> graph, int parent, List<Boolean> hasApple)
    {
      
       
        
          Pair ans = new Pair(0,hasApple.get(src));
        for(int nbr : graph.get(src))
        {
            if(nbr!=parent)
            {   
                Pair pr=dfs(nbr,graph,src,hasApple);
                
                if(pr.isApplePresent == true)  
                {
                    ans.time+=(pr.time+2);
                    ans.isApplePresent |=pr.isApplePresent;
                }
            }
        }
        
         return ans;
    }
}