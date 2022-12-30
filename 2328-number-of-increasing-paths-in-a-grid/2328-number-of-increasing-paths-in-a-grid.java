class Solution {
        int mod=(int)1e9+7;
    public int countPaths(int[][] grid) {
        long[][] dp=new long[grid.length][grid[0].length];
        
        for(long[] a: dp)
        {
            Arrays.fill(a,-1);
        }
        
        long ans=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                ans = (ans+dfs(i,j,grid,Integer.MIN_VALUE,dp))%mod;
            }
        }
        
        return (int)ans;
    }
    
    long dfs(int i, int j, int[][] grid,int preVal,long[][] dp)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || preVal>=grid[i][j])
        {
            return 0;
        }
        
        if(dp[i][j] != -1) return dp[i][j];        
        long top = dfs(i-1,j,grid,grid[i][j],dp);
        long right = dfs(i,j+1,grid,grid[i][j],dp);
        long bottom = dfs(i+1,j,grid,grid[i][j],dp);
        long left = dfs(i,j-1,grid,grid[i][j],dp);
        
        return dp[i][j]=(top+right+bottom+left + 1)%mod;
    }
}