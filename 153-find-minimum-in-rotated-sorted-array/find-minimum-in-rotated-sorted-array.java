class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;
        int ans = 0;// default ans;


        while(lo <= hi){

            int mid = lo + (hi - lo)/2;
            
            if(check(mid, nums) == 1){
                ans = mid;
                hi = mid -1;
            }
            else{
                lo = mid + 1;
            }

        }
        return nums[ans];

    }
    
    private int check(int mid, int[] nums){

        if(nums[mid] < nums[0]){
            return 1;
        }
        else{
            return 0;
        }
    }
}