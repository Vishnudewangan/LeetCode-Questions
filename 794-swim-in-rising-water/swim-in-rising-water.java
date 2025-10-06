class Solution {
    
    static class Pair implements Comparable<Pair>
    {
        int row;
        int col;
        int msf;
        
        Pair(int row, int col,int msf)
        {
            this.row = row;
            this.col = col;
            this.msf = msf;
        }
        
        public int compareTo(Pair o)
        {
            return this.msf - o.msf;
        }
    }
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        
        pq.add(new Pair(0,0,grid[0][0]));
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dir = {{-1,0},{0,1},{1,0}, {0,-1}};
        
        while(pq.size()>0)
        {
            Pair rem = pq.remove();
            
            if(rem.row== grid.length-1 && rem.col==grid[0].length-1)
            {
                return  rem.msf;
            }
            
            if(vis[rem.row][rem.col]==true)
            {
                continue;
                
            }
            
            vis[rem.row][rem.col]=true;
            
            
            for(int i=0;i<4;i++)
            {
                int xx= rem.row+dir[i][0];
                int yy = rem.col + dir[i][1];
                
                if(xx < 0 || yy <0 || xx >= grid.length || yy >=grid[0].length || vis[xx][yy]==true)
                {
                    continue;
                }
                
                
                pq.add(new Pair(xx, yy, Math.max(rem.msf, grid[xx][yy])));
            }
        }
        
        return 0;
        
    }
}