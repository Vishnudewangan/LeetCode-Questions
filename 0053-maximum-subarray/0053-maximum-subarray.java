class Solution {
    public int maxSubArray(int[] nums) {
     
        
        int maxSum=nums[0];
        int sumSoFar = nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            if(sumSoFar < 0)
            {
                sumSoFar = nums[i];
            }
            else
            {
                sumSoFar += nums[i];
            }
            
            maxSum= Math.max(sumSoFar , maxSum);
        }
        return maxSum;
    }
}