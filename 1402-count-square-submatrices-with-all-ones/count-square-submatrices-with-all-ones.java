class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp=new int[m][n];
        
        
        int sum =0;
        for(int i=0;i<m;i++)
        {
            dp[i][n-1]=matrix[i][n-1];
            sum+=dp[i][n-1];
        }
        
        for(int j=0;j<n-1;j++)
        {
            dp[m-1][j]=matrix[m-1][j];
            sum+=dp[m-1][j];
        }
        
        // sum+=dp[m-1][n-1];
        
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {    
                if(matrix[i][j]==0)
                dp[i][j] = 0;
                else
                {
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i][j+1],dp[i+1][j+1])) + 1;
                    sum+=dp[i][j];
                    
                }   
            }
            
        }
        
        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         // System.out.print(dp[i][j] +" ");
        //         sum+=dp[i][j];
        //     }
        //     // System.out.println();
        // }
        
        return sum;
        
        
    }
}