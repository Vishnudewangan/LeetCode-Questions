class Solution {
    public int minIncrementForUnique(int[] nums) {
     Arrays.sort(nums);
        int sum=0;
        int count=0;
        sum=nums[0];
        for(int i=1;i< nums.length;i++)
        {
            if(nums[i] <= nums[i-1])
            {
                count+=Math.abs(nums[i] - nums[i-1])+1;
                nums[i] = 1+nums[i-1];
            }
            sum+=nums[i];
        }
        
        return count;
    }
}