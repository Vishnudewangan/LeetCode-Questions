class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        boolean[][] vis=new boolean[m][n];
        
        int count=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {    
                if(i*j==0 || i==m-1 || j==n-1)
                {
                    getConnectedComponents(i,j,grid);
                }
                
            }
        }
        
         for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {    
                if(grid[i][j]==0)
                {  getConnectedComponents(i,j,grid);
                    count++;
                }
                
            }
        }
        return count;
    }
    
   void  getConnectedComponents(int i, int j, int[][] grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ||grid[i][j]==1  )
        {
           return ;
        }
         
        grid[i][j]=1;
         
         //top
        getConnectedComponents(i-1,j,grid);
         
         // right
          getConnectedComponents(i,j+1,grid);
         // bottom
      getConnectedComponents(i+1,j,grid);
         // left
         getConnectedComponents(i,j-1,grid);
       
      
    }
}