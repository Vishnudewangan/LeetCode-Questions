class Solution {
    public int[] buildArray(int[] nums) {
      
        int[] arr =new int[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            int idx = nums[i];
            arr[i] =nums[idx];
        }
        
        return arr;
    }
}