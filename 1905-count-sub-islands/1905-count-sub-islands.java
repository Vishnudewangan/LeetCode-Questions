class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int m=grid1.length;
        int n=grid1[0].length;
        
        // removing all uncommon land's from grid2
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j]==1 && grid1[i][j]==0)
                {
                    dfs(i,j,grid2);
                }
            }
        }
        
        // count common land's -> sub island
        
        int count=0;  
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j]==1)
                {
                    dfs(i,j,grid2);
                    count++;
                }
            }
        }
        
        return count++;
    }
    
    public void dfs(int i, int j, int grid2[][])
    {
        if(i<0 || j<0 ||i>=grid2.length || j>=grid2[0].length || grid2[i][j]==0)
        {
            return ;
        }
        // grid2[i][j] ==1  mark 0 with all connected ones
        grid2[i][j]=0;
        
        //top
         dfs(i-1,j,grid2);
        //right
        dfs(i,j+1,grid2);
        // bottom
        dfs(i+1,j,grid2);
        
        // left
        dfs(i,j-1,grid2);
    }
}