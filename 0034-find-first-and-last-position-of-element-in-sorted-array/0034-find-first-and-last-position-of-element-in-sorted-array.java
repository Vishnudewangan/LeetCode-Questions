class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left= binarySearch(nums,target);
       
        int right = binarySearch(nums,target+1);
        
        if(left < nums.length && nums[left]== target)
        return new int[]{left,right-1};
        
        return new int[]{-1,-1};
    }
    int binarySearch(int[]arr, int tar)
    {
        int left=0,right = arr.length-1;
        
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            
            if(arr[mid] < tar)
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        
        return left;
    }
}