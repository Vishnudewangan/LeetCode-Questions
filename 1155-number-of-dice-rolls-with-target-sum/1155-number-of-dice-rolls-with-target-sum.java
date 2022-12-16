class Solution {
    
    long mod = (long)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        
       long[][] dp=new long[n+1][target+1];
        
        for(long[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        
        return  (int)helper(n,target,k,dp);
    }
    
    long helper(int n, int target ,int k,long[][] dp)
    {  
        if((n==0 && target!=0)|| (n>0 && target<0))return 0 ;
        if(n==0 && target==0) return 1;
         
        if(dp[n][target]!=-1) return dp[n][target];
        long count=0;
        for(int i=1;i<=k;i++)
        {
          count+=(helper(n-1,target-i,k,dp)%mod);
        }
        
        return dp[n][target]=count%mod;
    }
}