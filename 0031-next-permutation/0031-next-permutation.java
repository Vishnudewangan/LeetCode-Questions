class Solution {
    public void nextPermutation(int[] nums) {
        
        int i=nums.length-2;
        
        while(i>=0 && nums[i+1]<=nums[i])
        {
            i--;
        }
        
        if(i>=0)
           {
               int j=nums.length-1;
            
                while(j>=0 && nums[j] <= nums[i])
                {
                  j--;
                }
            
              swap(nums,i,j);
           }
        
           reverse(nums,i+1);
    }
    
    void swap(int[] arr,int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void reverse(int[] arr, int k)
    {
        int l = arr.length-1;
        
        while(k < l)
        {
            int temp = arr[l];
            arr[l] = arr[k];
            arr[k] = temp;
            
            k++;
            l--;
        }
    }
}