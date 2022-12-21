class Solution {
    
     static class Pair{
         int v;
         int sn;
         
         Pair(int v, int sn)
         {
             this.v= v;
             this.sn=sn;
         }
     }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] dislike : dislikes)
        {
            int u = dislike[0]-1;
            int v= dislike[1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        
      for(int i=0;i<n;i++)
      {
          if(vis[i]==-1)
          {
              boolean comp=compBipartite(i,graph,vis);
              if(comp==false) return false;
          }
      }
        
        return true;
        
    }
    boolean compBipartite(int src, ArrayList<ArrayList<Integer>> graph,int[] vis)
    {
          Queue<Pair> que =new ArrayDeque<>();
        
        que.add(new Pair(src,0));
        while(que.size()>0)
        {
            Pair rem =que.remove();
            
            if(vis[rem.v]!=-1)
            {
                int osn = vis[rem.v];
                int nsn = rem.sn;
                
                if(osn!=nsn)
                {
                    return false;
                }
                continue;
            }
            vis[rem.v] = rem.sn;
            
            for(int nbr : graph.get(rem.v))
            {
                int sn = rem.sn==0?1 : 0;
                
                que.add(new Pair(nbr,sn));
            }
        }
        
        return true;
        
    }
}