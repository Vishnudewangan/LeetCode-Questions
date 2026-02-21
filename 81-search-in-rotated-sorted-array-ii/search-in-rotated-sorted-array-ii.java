class Solution {
    public boolean search(int[] nums, int target) {
        
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi){

            while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
            while(lo < hi && nums[hi] == nums[hi -1]) hi--;

            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target) return true;
            else if(nums[lo] <= nums[mid])// means sorted from lo to mid
            {
                if(target>=nums[lo] && target<=nums[mid]){
                    hi = mid -1;
                }
                else{
                    lo = mid+1;
                }
            }
            else if(nums[mid]<=nums[hi]){
                if(target>=nums[mid] && target<= nums[hi]){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return false;
    }
}