class Solution {
    public int findNumberOfLIS(int[] nums) {
       
        int[] dp =new int[nums.length];
        int[] cnt = new int[nums.length];
        
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        
        int omax=1;
        
        for(int i=1;i<nums.length;i++)
        {
            
            
            for(int j=0;j<i;j++)
            {
                if(nums[j] < nums[i] && dp[j]+1> dp[i])
                {
                            dp[i]=dp[j]+1;
                    cnt[i] = cnt[j];
                }
                else if(nums[j] < nums[i] && dp[j]+1 == dp[i])
                {
                    cnt[i] =cnt[i] + cnt[j];
                }
            }
            
           
            omax=Math.max(omax,dp[i]);
        }
        
        int count=0;
        
        for(int i=0;i<dp.length;i++)
        {
            if(omax==dp[i])
            {
                count+=cnt[i];
            }
        }
      
        return count;
    }
}