class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj =new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<roads.length;i++)
        {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
            
        }
        
        int mod = (int)1e9+7;
        
        
        long[] ways=new long[n];
        long[] dist= new long[n];
        
        for(int i=0;i<n;i++)
        {
            dist[i] = (int)1e18;
        }
        
        ways[0]=1;
        dist[0] = 0;
        
        PriorityQueue<Pair> pq =new PriorityQueue<>((Pair p,Pair q)->{
              
            return p.wt - q.wt;
        });
        
        pq.add(new Pair(0,0));
        
        while(pq.size()>0)
        {
            Pair rem =pq.remove();
            
            int node = rem.node;
            int wsf = rem.wt;
            
            
            for(Pair p : adj.get(node) )
            {   
                int adjNode= p.node;
                int adjWt = p.wt;
                
                if(wsf + adjWt < dist[adjNode])
                {
                    dist[adjNode] =wsf + adjWt;
                    pq.add(new Pair(adjNode, wsf + adjWt));
                    ways[adjNode] = ways[node];
                }
                else if(wsf + adjWt == dist[adjNode])
                {
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;
                }
            }
        }
        
        return (int)ways[n-1]%mod;
    }
    
    static class Pair{
        int node;
        int wt ;
        Pair(int node, int wt)
        {
          this.node = node;
          this.wt = wt;
        }
    }
}