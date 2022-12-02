class Solution {
    public boolean search(int[] nums, int target) {
        
        int lo = 0,hi = nums.length-1;
        
        while(lo<=hi)
        {
            while(lo<hi && nums[lo]==nums[lo+1])
            lo++;
            while(hi>0 && nums[hi]==nums[hi-1])
            hi--;
            
            
            int mid =lo +(hi-lo)/2;
            
            
            if(nums[mid]==target)
            {
                return true;
            }
            else if(nums[lo]<=nums[mid])
            {
               if(nums[lo]<=target && target<=nums[mid])
               {
                   hi=mid-1;
               }
                else
                {
                    lo=mid+1;
                }
            }
            else if(nums[mid]<=nums[hi])
            {
               if(nums[mid]<=target && target<=nums[hi])
               {
                  lo=mid+1;
               }
                else
                {
                    hi = mid-1;
                }
            }
            
        }
        
        return false;
    }
}