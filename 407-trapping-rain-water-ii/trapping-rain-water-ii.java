class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m=heightMap.length;
        int n= heightMap[0].length;
        
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        
        boolean[][] vis =new boolean[m][n];
        
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==m-1 || j==n-1)
                {
                    pq.add(new Pair(i,j,heightMap[i][j]));
                    vis[i][j] =true;
                }
            }
        }
        
        int[][] dirs={{0,1},{-1,0},{0,-1},{1,0}};
        
        int water=0;
        
        while(pq.size()>0)
        {
            Pair rem = pq.remove();
            
            for(int[] dir:dirs)
            {
                int rowdash = rem.row+dir[0];
                int coldash =rem.col+dir[1];
                
                if(rowdash >=0 && coldash>=0 && rowdash<m && coldash < n && vis[rowdash][coldash]==false)
                {
                    
                    water+=Math.max(0, rem.height - heightMap[rowdash][coldash]);
                    
                    if(rem.height <= heightMap[rowdash][coldash])
                    {
                        pq.add(new Pair(rowdash,coldash,heightMap[rowdash][coldash]));
                    }
                    else
                    {
                        pq.add(new Pair(rowdash,coldash,rem.height));
                    }
                    vis[rowdash][coldash] = true;
                }
            }
        }
        
        return water;
            
    }
    static class Pair implements Comparable<Pair>
    {
        int row;
        int col;
        int height;
        
        Pair(int row, int col,int height)
        {
            this.row = row;
            this.col=col;
            this.height = height;
        }
        
        public int compareTo(Pair o)
        {
            return this.height - o.height;
        }
    }
}