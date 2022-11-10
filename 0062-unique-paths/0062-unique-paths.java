class Solution {
    public int uniquePaths(int m, int n) {
        
        // recursion + memoization
        
        
//         int[][] dp = new int[m][n];
//         for(int[] arr : dp){
//             Arrays.fill(arr,-1);
//         }
         
//         return helper(0,0,m,n,dp);
        
        
//     }
    
//     int helper(int r,int c,int m ,int n,int[][] dp)
//     {   
//         if(r>=m || c>=n) return 0;
//         if(r==m-1 && c==n-1) return 1;
        
//         if(dp[r][c]!=-1) return dp[r][c];
        
//         return dp[r][c] = helper(r+1,c,m,n,dp) + helper(r,c+1,m,n,dp);
        
        /// tabulation
        
        
       int[][] dp=new int[m][n];
        
        for(int i=0;i<n;i++)
        {
            dp[m-1][i] = 1; 
        }
        
        for(int j=0;j<m;j++)
        {
            dp[j][n-1]= 1;
            
        }
        
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
}