class Solution {
    public int countOrders(int n) {
        if(n==1) return 1;
        long[] dp =new long[n+1];
        
        dp[1] = 1L;
        dp[2] = 6L;
        
        for(int i=3;i<=n;i++)
        {
            long odd = (2*i-1);
            
            long permutaion = odd *(odd+1)/2;
            
            dp[i] = (dp[i-1]*permutaion)%(long)(1e9+7);
        }
        return (int)dp[n];
    }
}