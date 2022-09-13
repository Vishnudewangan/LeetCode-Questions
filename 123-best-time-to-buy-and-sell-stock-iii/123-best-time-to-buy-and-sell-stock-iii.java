class Solution {
    public int maxProfit(int[] prices) {
        
        int n= prices.length;
        int[] dp1=new int[n];// dp1[i] =-> 0 to i max profit with one transaction
        int[] dp2=new int[n]; // dp2[i] =-> i to n max profit with one transaction
        
        int lpsf = prices[0];
        
        for(int i=1;i<n;i++)
        {
            if(prices[i] < lpsf)
            {
              lpsf= prices[i];
            }
            
            int cbp = dp1[i-1]; // completed before profit
            int cip = prices[i] - lpsf ; // completed at i profit
            
            
            dp1[i] = Math.max(cbp , cip);
        }
        
        int mpsf = prices[n-1];
        
        
        for(int i=n-2;i>=0;i--)
        {
            if(prices[i] > mpsf)
            {
                mpsf = prices[i];
            }
            
             int cbp = dp2[i+1]; // completed after profit
            int cip = mpsf-prices[i] ; // buy point at i 
            
            
            dp2[i] = Math.max(cbp , cip);
        }
        
        
        int max= 0;
        
        for(int i=0;i<n;i++)
        {
            if(dp1[i]+ dp2[i] >max)
            {
                max= dp1[i] + dp2[i];
            }
        }
        
        return max;
        
        
    }
}