class Solution {
    public void wiggleSort(int[] nums) {
        
         Arrays.sort(nums);
        
        int[] res =new int[nums.length];
        
        // odd index;
        
        int i=1;
        int k=nums.length-1;
        
        
        while(i< nums.length)
        {
            res[i] = nums[k];
            k--;
            i+=2;
        }
        
        
        // even index;
        
        i = 0;
        
        while(i<nums.length)
        {
            res[i] = nums[k];
            k--;
            i+=2;
        }
        
        for( i=0;i<res.length;i++)
        {
            nums[i] = res[i];
        }
    }
}