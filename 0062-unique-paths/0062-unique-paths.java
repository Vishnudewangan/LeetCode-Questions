class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
         
        for(int[] temp : dp)
        {
            Arrays.fill(temp,-1);
        }
        return solve(0,0,m,n, dp);
    }
    
    int solve(int row,int col,int m,int n,int[][] dp)
    {   
        if(row>=m || col>=n) return 0;
       if(row==m-1 && col==n-1) return 1;
        
        if(dp[row][col]!=-1)return dp[row][col];
        
       int d =solve(row+1,col,m,n,dp);
       int r=solve(row,col+1,m,n,dp);
        
        return dp[row][col]= d+r;
        
    }
}