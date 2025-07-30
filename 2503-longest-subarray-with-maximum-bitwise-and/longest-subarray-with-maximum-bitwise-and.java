class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            max =Math.max(max,nums[i]);
        }   

        int largestSubArray=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==max)
            {
                int cnt=1;
                i++;
                while(i< nums.length && nums[i]==max)
                {
                   cnt++;
                   i++;
                }
                largestSubArray = Math.max(cnt, largestSubArray);
            }
        }

        return largestSubArray;
    }
}