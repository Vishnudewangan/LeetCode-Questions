class Solution {
    public int firstMissingPositive(int[] nums) {
        int pe = segregate(nums);
        
        for(int i=0;i<=pe;i++)
        {
            int idx = Math.abs(nums[i])-1;
            
            if(idx<=pe && nums[idx]>0)
            {
                nums[idx] = -nums[idx];
            }
        }
        
        for(int i=0;i<=pe;i++)
        {
            if(nums[i]>0)
            {
                return i+1;
            }
            
            
        }
        
        return pe+2;
    }
    
    int segregate(int[] arr)
    {
        int i=0,j=0;
        
        while(i< arr.length)
        {
            if(arr[i]<=0)
            {
                i++;
                
            }
            else
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]  = temp;
                
                i++;
                j++;
            }
        }
        
        return j-1;
    }
}