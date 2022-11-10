class Solution {
    
    
  
    public int shortestBridge(int[][] grid) {
            int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
           Queue<int[]> que=new LinkedList<>();
      outer:  for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {   
                if(grid[i][j]==1){
                getConnectedComponent(i,j,grid,que);
                break outer ;
                }
            }
        }
        
       // System.out.println(que);
        
        int step=0;
         
        while(que.size()>0)
        {
            
            int size= que.size();
            for(int c=0;c<size;c++)
            {
            int[] pos= que.remove();
            
            int x=pos[0];
            int y=pos[1];
            
            for(int i=0;i<4;i++)
            {
                int xx=dir[i][0]+x;
                int yy = dir[i][1]+y;
                
                if(xx>=0 && yy>= 0 && xx<grid.length && yy<grid[0].length && grid[xx][yy]!=2)
                {
                   
                
                if(grid[xx][yy]== 1) return step;
                    grid[xx][yy]=2;
                que.add(new int[]{xx, yy});
               
                }
                
                
            }
                
            }
            step++;
            
        }
        
        return -1;
        
    }
    
    void  getConnectedComponent(int i, int j, int[][] grid, Queue<int[]> que)
    {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j]!=1)
        {
            return ;
        }
        
        que.add(new int[]{i,j});
      
        grid[i][j]=2;
        
       getConnectedComponent(i-1,j,grid,que);
        
        getConnectedComponent(i,j+1,grid,que);
        getConnectedComponent(i+1,j,grid,que);
        getConnectedComponent(i,j-1,grid,que);
        
        
    }
}