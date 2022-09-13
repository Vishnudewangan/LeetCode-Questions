class Solution {
    public int maxProfit(int[] prices, int fee) {
         
        int obsp = - prices[0];
        int ossp = 0;
        
        for(int i=1;i<prices.length;i++)
        {
            int nbsp = Math.max(obsp , ossp-prices[i]);
            int nssp =Math.max(ossp, obsp+ prices[i] - fee);
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    
    }
}