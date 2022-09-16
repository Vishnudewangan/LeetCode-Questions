class Solution {
    public int maxProfit(int k, int[] prices) {
        
          int n = prices.length;
        int[][] dp=new int[k+1][n];
        
        // dp[i][j] -> jth day , i transaction -> max profit
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                
                if(i==0)
                {
                    // 0 transaction
                    
                    dp[i][j]=0;
                }
                else if(j==0)
                {
                    // 0 th day
                    
                    dp[i][j] = 0;
                }
                else
                {
                    int max= dp[i][j-1];// no transaction
                    
                    
                    // single transaction options
                    for(int pd=j-1; pd>=0;pd--)
                    {
                       int res = prices[j] - prices[pd] + dp[i-1][pd];
                        
                        if(res > max)
                        {
                            max= res;
                        }
                        
                    }
                    
                    dp[i][j] = max;
                }
               
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}