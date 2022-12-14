class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
       return robbed(nums,nums.length-1,dp);
    }
    
    int robbed(int[] nums,int idx,int[] dp)
    {   if(idx<0) return 0;
        if(idx==0)
        {
            return nums[0];
        }
            if(dp[idx]!=-1) return dp[idx];
            
            int f1=robbed(nums,idx-2,dp)+nums[idx];
            int f2=robbed(nums,idx-1,dp);
        
           return dp[idx]= Math.max(f1,f2);
    }
}