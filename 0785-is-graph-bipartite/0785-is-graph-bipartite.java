class Solution {
    
     static class Pair
     {
         int v;
         int sn;
         
         Pair(int v, int sn)
         {
             this.v=v;
             this.sn= sn;
         }
     }
    public boolean isBipartite(int[][] graph) {
        
      int[] vis=new int[graph.length];
         
        Arrays.fill(vis,-1);
        
        for(int i=0;i<graph.length;i++)
        {
            if(vis[i]==-1)
            {
                boolean sca = isCompBipartite(i,graph,vis);
                
                if(sca==false) return false;
                
        }
            
    }
            return true;
    }
        boolean isCompBipartite(int src, int[][] graph,int[] vis)
        {
            Queue<Pair> que=new ArrayDeque<>();
            
            que.add(new Pair(src,0));
            
            while(que.size()>0)
            {
                // remove 
                Pair rem=que.remove();
                // mark *
                 if(vis[rem.v]!=-1)
                 {
                     int osn = rem.sn;
                     int nsn = vis[rem.v];
                     
                     if(osn!=nsn)
                     {
                         return false;
                     }
                     continue;
                 }
                vis[rem.v]=rem.sn;
                // work
                 
                // add unvisited nbr
                
                for(int nbr : graph[rem.v])
                {
                    if(vis[nbr]==-1)
                    {
                        int sn = rem.sn==1? 0:1;
                        
                        que.add(new Pair(nbr,sn));
                    }
                }
                
             }
             return true;
        }
    
    
}