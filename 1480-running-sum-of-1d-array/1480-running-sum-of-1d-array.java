class Solution {
    public int[] runningSum(int[] nums) {
        
        int[] arr =new int[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                arr[i] =nums[i];
            }
            else
            {
                arr[i] = nums[i]+arr[i-1];
            }
        }
        return arr;
    }
}