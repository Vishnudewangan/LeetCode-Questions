class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
          
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] vis =new boolean[graph.length];
        helper(0,graph,vis,ans,list);
        
        return ans;
    }
    
    void helper(int src,int[][] graph,boolean[] vis,List<List<Integer>> ans, List<Integer> list)
    {
        vis[src] = true;
        
        list.add(src);
        if(src==graph.length-1)
        {
            ans.add(new ArrayList<>(list));
           
        }
        
        for(int nbr : graph[src])
        {
            if(vis[nbr]==false)
            {
                helper(nbr,graph,vis,ans,list);
            }
        }
        
        vis[src] = false;
        list.remove(list.size()-1);
    }
    
}