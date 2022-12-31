class Solution {
    int count;
    public int uniquePathsIII(int[][] grid) {
        count=0;
      int si=0,sj=0,bspace=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                   si=i;
                    sj= j;
                    bspace++;
                }
                if(grid[i][j]==0)
                {
                    bspace++;
                }
            }
        }
        
        dfs(si,sj,bspace,0,grid);
        
        return count;
    }
    
    void dfs(int i,int j,int tspace,int bspace,int[][] grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1 ) return;
        
        if(grid[i][j]==2 && tspace==bspace)
        {
            count++;
            return;
        }
        
         bspace++;
        int val = grid[i][j];
        
        grid[i][j] = -1;
        
        dfs(i-1,j,tspace,bspace,grid);
        dfs(i,j+1,tspace,bspace,grid);
        dfs(i+1,j,tspace,bspace,grid);
        dfs(i,j-1,tspace,bspace,grid);
        
        grid[i][j] = val;
    }
}