class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = n-1;
        int ans = n-1;//default ans;

        while(lo<=hi){
            int mid = lo + (hi - lo)/2;

            if(check(mid, nums)==1)
            {
               ans = mid;
               hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }
    private static int check(int mid, int[] arr){
        if(mid == arr.length - 1) return 1;

        if(arr[mid] > arr[mid+1]) return 1;
        else return 0;
    }
}