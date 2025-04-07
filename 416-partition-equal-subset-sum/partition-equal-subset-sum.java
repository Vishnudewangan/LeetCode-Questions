class Solution {
     int[][] dp;
    public boolean canPartition(int[] nums) {
       
        int sum=0;
        
        for(int val: nums)
        {
            sum+=val;
        }
        
        
        if((sum&1)==1) return false;
        
        dp=new int[nums.length][sum/2+1];
         for(int[] a :dp)
         {
            Arrays.fill(a,-1);
         }
        
        return  isSubsetSum(nums,nums.length-1,sum/2);
     }
    
    boolean isSubsetSum(int[] nums,int idx,int sum)
    {
        if(idx<0) return false;
        
        if(idx>=0 && nums[idx]==sum) return true;
        
        if(dp[idx][sum]!=-1) return dp[idx][sum]==0? false: true;
        
        
        if(nums[idx]<=sum)
        {
            boolean f1=isSubsetSum(nums,idx-1,sum-nums[idx]);
            boolean f2=isSubsetSum(nums,idx-1,sum);
            
            dp[idx][sum]=f1|| f2 == false? 0 : 1;
            
            return  f1 || f2;
            
        }
        else
        {
            boolean f=isSubsetSum(nums,idx-1,sum);
             dp[idx][sum]= f==false ? 0 : 1;
            return f;
        }
        
    }
}