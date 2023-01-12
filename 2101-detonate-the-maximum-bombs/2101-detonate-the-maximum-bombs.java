class Solution {
    int count;
    public int maximumDetonation(int[][] bombs) {
        
        HashMap<Integer,List<Integer>> graph =new HashMap<>();
        
        int n= bombs.length;
        
        for(int i=0;i<n;i++) graph.put(i,new ArrayList<>());
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(isDetonate(bombs[i],bombs[j]))
                {
                    graph.get(i).add(j);
                }
                
                if(isDetonate(bombs[j],bombs[i]))
                {
                    graph.get(j).add(i);
                }
                
                
            }
        }
        
        
        int result= 0;
        for(int i=0;i<n;i++)
        { 
                count=0;
                boolean[] vis=new boolean[n];
               dfs(i,graph,vis);
                result = Math.max(result,count);
            
        }
        
        return result;
    }
    
    void dfs(int src, HashMap<Integer,List<Integer>> graph,boolean[] vis)
    {
        vis[src]=true;
        
        count++;
        
        for(int nbr : graph.get(src))
        {
            if(vis[nbr]==false)
            {
                dfs(nbr,graph,vis);
            }
        }
    }
    private boolean isDetonate(int[] bomb1, int[] bomb2)
    {
        long dx = bomb1[0] - bomb2[0];
        long dy = bomb1[1] - bomb2[1];
        
        long r = bomb1[2];
        
        return dx*dx + dy*dy <=r*r;
    }
}