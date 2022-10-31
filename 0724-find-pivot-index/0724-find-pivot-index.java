class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = 0;
        for(int val : nums)
        {
            sum+=val;
        }
       int psum=0;
        
        for(int i=0;i<nums.length;i++)
        {   
            if(psum == sum-psum-nums[i])
            {
                return i;
            }
            psum+=nums[i];
        }
        
        return -1;
    }
}