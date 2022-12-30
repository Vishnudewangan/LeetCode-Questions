class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<int[]>[] graph =new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            graph[i]= new ArrayList<>();
        }
        
        for(int[] flight : flights)
        {
       
            graph[flight[0]].add(new int[]{flight[1],flight[2]});
        }
        
        int[][] dp =new int[n][k+1];
        
         for(int[] a : dp)
         {
             Arrays.fill(a,-1);
         }
        
        int ans = dfs(src,k,dst,graph,dp);
        
        return ans==(int)1e7? -1 : ans;
    }
    
    int dfs(int src, int k , int dst, ArrayList<int[]>[] graph,int[][] dp)
    {
        if(src==dst) return 0;
        
        if(k<0) return (int)1e7;
        
        if(dp[src][k]!=-1) return dp[src][k];
        
        int min = (int)1e7;
        
        
        for(int[] edge : graph[src])
        {    
            int nbr = edge[0];
            int wt = edge[1];
            
                min= Math.min(min, wt+dfs(nbr,k-1,dst,graph,dp));
            
        }
        return  dp[src][k]=min;
    }
}