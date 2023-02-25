class Solution {
    public int maxProfit(int[] prices) {
        
       int oap=0;
        
        int msf=prices[0];
        
        for(int i=0;i<prices.length;i++)
        {
            oap=Math.max(prices[i]-msf,oap);
            
            msf=Math.min(prices[i],msf);
        }
        
        return oap;
        
        
    }
}