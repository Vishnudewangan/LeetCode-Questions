class Solution {
    public int numEnclaves(int[][] grid) {
        
       
        
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0 ;j<n;j++)
            {
                if(i*j==0 || i==m-1 || j==n-1)
                {
                    floodFill(i,j,grid);
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {  
                    count++;
                   
                }
            }
        }
        
        return count;
    }
    
    public void floodFill(int i, int j, int[][] grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        {
            return ;
        }
        
        grid[i][j] = 0;
       
        
        // top
          floodFill(i-1,j,grid);
        // right
          floodFill(i,j+1,grid);
        // bottom
          floodFill(i+1,j,grid);
        // left
          floodFill(i,j-1,grid);
        
    }
   
}