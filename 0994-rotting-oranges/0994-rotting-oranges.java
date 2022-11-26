class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fo=0;
        
        int[][] dir ={{-1,0},{0,1},{1,0},{0,-1}};
        
        Queue<int[]> que =new ArrayDeque<>();
        int m = grid.length;
        int n= grid[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    grid[i][j]=-1;
                    que.add(new int[]{i,j});
                    
                }
                else if(grid[i][j] == 1)
                {
                    fo++;
                }
            }
        }
        
        if(fo==0) return 0;
        
        
        int time =0;
        
        while(que.size()>0)
        {
            int size=que.size();
            
            for(int i=0;i<size;i++)
            {
                int[] rem= que.remove();
                
                int r= rem[0];
                int c= rem[1];
                
                for(int d=0;d<4;d++)
                {
                    int rr = r + dir[d][0];
                    int cc = c + dir[d][1];
                    
                    
                    if(rr>=0 && cc>=0 && rr< m && cc<n && grid[rr][cc]==1)
                    {
                       grid[rr][cc]=-1;
                        que.add(new int[]{rr,cc});
                        fo--;
                    }
                }
                 
            }
            time++;
           
        }
        
        if(fo>0) return -1;
        
        return time-1;
        
        
    }
}