class Solution {
    int parent[] ;
    int rank[];
    public int findCircleNum(int[][] isConnected) {
       
        int n = isConnected.length;
        
        parent = new int[n+1];
        rank  = new int[n+1];
        
        for(int i=1;i<=n;i++)
        {
            parent[i] =i;
            rank[i]=0;
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 )
                {
                    union(i+1,j+1);
                }
            }
        }
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(parent[i]==i)
            {
                count++;
            }
        }
        return count;
       }
    
    void union(int u,int v)
    {
        int slu = find(u);
        int slv = find(v);
        
        if(slu!=slv)
        {
            int ru = rank[u];
            int rv = rank[v];
            
            if(ru < rv)
            {
                parent[slu]=slv;
            }
            else if(rv>ru)
            {
                parent[slv]=slu;
            }
            else
            {
                parent[slu]=slv;
                rank[slv]++;
            }
        }
    }
    
    int find(int x)
    {
        if(parent[x]==x) return x;
        
        return parent[x] = find(parent[x]);
    }
}