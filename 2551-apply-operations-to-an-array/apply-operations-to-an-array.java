class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n= nums.length;
        
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }
        
        int i=0,j=0;
        
        while(i<n)
        {
            if(nums[i]==0)
            {
                i++;
            }
            else
            {
                swap(nums,i,j);
                i++;
                j++;
            }
        }
        
        return nums;
    }
    
    void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}