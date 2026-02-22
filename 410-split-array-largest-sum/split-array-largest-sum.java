class Solution {
    public int splitArray(int[] nums, int k) {
        
        long lo = Arrays.stream(nums).min().getAsInt();// min possible sum
        long hi = Arrays.stream(nums).asLongStream().reduce(0L,(a,b)-> a+b);// max possible sum

        long ans = hi;

        while(lo <= hi)
        {
            long mid = lo + (hi - lo)/2; // sum of subarray

            if(check(mid,nums,k)==1){
               ans = mid;
               hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return (int)ans;
    }

    private int check(long mid, int[] nums, int splitAllowed){
        int splitRequired = 0;
        long sumSoFar = 0;
        //System.out.print("for sum : " + mid + " ");
        for(int val : nums){
            if(val > mid) return 0;
            if(sumSoFar + val >= mid){
                splitRequired++;
                sumSoFar = sumSoFar + val == mid ?  0 : val;
                if(splitRequired > splitAllowed) return 0;
            }
            else{
                sumSoFar += val;
            }
        }
        if(sumSoFar > 0) splitRequired++;

        //System.out.println("split required : "+ splitRequired);

        if(splitRequired <= splitAllowed) return 1;
        else return 0;
    }
}