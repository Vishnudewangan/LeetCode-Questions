class Solution {
    public long countPairs(int n, int[][] edges) {
        
        
        UnionFind  uf = new UnionFind(n);
        
        for(int[] edge : edges)
        {
            uf.union(edge[0],edge[1]);
        }
        
        int[] size= new int[n];
        
        for(int i=0;i<n;i++)
        {
            size[uf.find(i)]++;
        }
        
        long ans =0;
        long remaining = n;
        
        for(int s : size)
        {
             if(s==0) continue;
            
            remaining-=s;
            
            ans +=remaining*s;
        
        }
         
        return ans;
        
    }
    
   class UnionFind
   {
       int[] parent;
       int[] rank;
       
       
       UnionFind(int n)
       {
           parent = new int[n];
           rank = new int[n];
           
           for(int i=0;i<n;i++)
           {
               parent[i] = i;
               rank[i] =1;
           }
       }
       
       int find(int x)
       {
           if(parent[x] == x) return x;
           
           return parent[x] = find(parent[x]);
       }
       
       void union(int x, int y)
       {
           int parentX = find(x);
           int parentY = find(y);
           
           if(parentX!=parentY)
           {
               if(rank[parentX] < rank[parentY])
               {
                   parent[parentX] = parentY;
                   rank[parentY]+= rank[parentX];
               }
               else
               {
                   parent[parentY]  = parentX;
                   rank[parentX] +=rank[parentY];
               }
           }
       }
   }
}