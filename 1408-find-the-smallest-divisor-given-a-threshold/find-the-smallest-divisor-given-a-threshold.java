class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int lo = 1; // smallest possible divisor
        int hi = Arrays.stream(nums).max().getAsInt();
       
       int ans = n;// default ans ; even if devide by largest possible divisor will quotient sum as n

       while(lo <= hi){
            
            int mid = lo + (hi - lo)/2;// divisor

            if(check(mid,nums,threshold) == 1){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
       }
       return ans;

    }

    private int check(int divisor, int[] nums, int threshold){

        int sumOfQuotient = 0;// possible sum of quotient with given divisor (mid)

        for(int dividend : nums){
            
            sumOfQuotient += (int)Math.ceil((double)dividend/divisor);
        }

        if(sumOfQuotient <= threshold) return 1;
        else return 0;
    }
}