class Solution {
    public int shortestBridge(int[][] grid) {
        
        int[][] dir ={{-1,0},{0,1},{1,0},{0,-1}};
        
        Queue<int[]> que =new ArrayDeque<>();
        
       outer: for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    getConnectedComponent(i,j,grid,que);
                    break outer;
                }
            }
        }
        
        
        int steps =0;
        
        while(que.size()>0)
        {
            int size=que.size();
            
            for(int i=0;i<size;i++)
            {
               int[] rem = que.remove();
                int x= rem[0];
                int y = rem[1];
                
                for(int d=0;d<4;d++)
                {
                    int xx= x + dir[d][0];
                    int yy = y+ dir[d][1];
                    
                    if(xx>=0 && yy>=0 && xx<grid.length && yy< grid[0].length && grid[xx][yy]!=2)
                    {    
                        if(grid[xx][yy]==1) return steps;
                        que.add(new int[]{xx,yy});
                        
                        grid[xx][yy]=2;
                        
                    }
                }
            }
            
            steps++;
            
            
        }
        
        return steps;
    }
    
    void getConnectedComponent(int i,int j,int[][] grid,Queue<int[]> que){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1)
        {
            return;
        }
        
        grid[i][j] = 2;
        
        que.add(new int[]{i,j});
        
        getConnectedComponent(i-1,j,grid,que);
        getConnectedComponent(i,j+1,grid,que);
        getConnectedComponent(i+1,j,grid,que);
        getConnectedComponent(i,j-1,grid,que);     
    }
    
    
}