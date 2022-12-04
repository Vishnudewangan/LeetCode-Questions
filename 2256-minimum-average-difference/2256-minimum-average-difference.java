class Solution {
    public int minimumAverageDifference(int[] nums) {
     
        int n = nums.length;
        long ans = Long.MAX_VALUE;
        int idx =-1;
        
         long totalSum=0;
        for(int i=0;i<nums.length;i++)
        {
           totalSum +=nums[i];
        }
         long currPrefixSum=0;
        for(int i=0;i<nums.length;i++)
        {   
            currPrefixSum+=nums[i];
            long avgith=  currPrefixSum/(i+1);
            long avgRest =  n-i-1 > 0 ? (totalSum - currPrefixSum)/(n-i-1) : 0 ;
            long avg = Math.abs(avgith - avgRest);
            if(ans > avg)
            {
                ans=avg;
                idx = i;
            }
        }
        
        return idx;
    }
}