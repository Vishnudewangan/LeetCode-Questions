class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
         
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                  int[] area = new int[1];
                    
                    dfs(i,j,grid,area);
                    
                    maxArea= Math.max(area[0],maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    void dfs(int i,int j,int[][] grid,int[] area)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] ==0)
        {
            return ;
        }
        
        area[0]++;
        grid[i][j] = 0;
        
        dfs(i-1,j,grid,area);
        dfs(i,j+1,grid,area);
        dfs(i+1,j,grid,area);
        dfs(i,j-1,grid,area);
    }
}