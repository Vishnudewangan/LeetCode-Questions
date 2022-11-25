class Solution {
    public long subArrayRanges(int[] nums) {
        long ans =0;
        
        int n = nums.length;
        
        for(int i=0;i<n;i++)
        {   
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=i;j<n;j++)
            {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j],max);
                
                ans+=(max-min);
            }
            
        }
        return ans;
    }
}