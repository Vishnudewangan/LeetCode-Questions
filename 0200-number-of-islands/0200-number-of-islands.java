class Solution {
    public int numIslands(char[][] grid) {
        
        int cnt=0;
        
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] =='1' && vis[i][j] == false)
                {
                    dfs(i,j,grid,vis);
                    cnt++; 
                }
            }
        }
        
        return cnt;
    }
    
    void dfs(int i,int j,char[][] grid,boolean[][] vis)
    {
        if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length || vis[i][j] ==true||grid[i][j] == '0')
        {
            return;
        }
        
        vis[i][j] = true;
        
        dfs(i-1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i+1,j,grid,vis);
        dfs(i,j-1,grid,vis);
    }
}