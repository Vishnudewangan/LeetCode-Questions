class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;

        int leftMost = binarySearch1(0,n-1,-1,nums,target);
        int rightMost = binarySearch2(0,n-1,-1,nums,target);

        return new int[]{leftMost, rightMost};
    }
    private int binarySearch1(int lo, int hi, int ans, int[] nums, int target){
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(check(mid,target,nums)== 1){
                ans = mid;
                hi = mid -1;
            }
            else if(check(mid,target,nums) == 2){
                lo = mid+1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
    private int binarySearch2(int lo, int hi, int ans, int[] nums, int target){
          while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(check(mid,target,nums)==1){
                ans = mid;
                lo = mid +1;
            }
            else if(check(mid,target,nums) == 2){
                lo = mid+1;
            }
            else {
                hi = mid -1;
            }
        }
        return ans;
    }
    private int check(int mid, int target, int[] nums){
        if(nums[mid] == target) return 1;
        else if(nums[mid] < target) return 2;
        else return -1;
    }
}