class Solution {
    public int maxProfit(int[] prices) {
        
        int obsp=-prices[0];
        int ossp=0;
        int ocsp=0;
        
        for(int i=1;i<prices.length;i++)
        {
            int nbsp= Math.max(obsp, ocsp - prices[i]);
            int nssp=Math.max(ossp, obsp+prices[i]);
            int ncsp = Math.max(ocsp , ossp+0);
            
              obsp = nbsp;
              ossp = nssp;
              ocsp = ncsp;
        }
        
        return ossp;
    }
}