class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs,(a,b)->{
            return a[0] - b[0];
        });
        
        int n = pairs.length;
        
        int[] dp =new int[n];
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {   
            int max=0;
            for(int j=i-1;j>=0;j--)
            {
                if(pairs[j][1] < pairs[i][0])
                {
                   max = Math.max(max,dp[j]);
                }
            }
            
            dp[i] = max+1;
            
            ans = Math.max(dp[i],ans);
        }
        
        return ans;
    }
}