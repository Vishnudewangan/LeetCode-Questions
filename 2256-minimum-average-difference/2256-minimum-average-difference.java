class Solution {
    public int minimumAverageDifference(int[] nums) {
     
        int n = nums.length;
        long ans = Long.MAX_VALUE;
        int idx =-1;
        
        long[] arr=new long[n];
        arr[0] = nums[0];
        for(int i=1;i<arr.length;i++)
        {
            arr[i] = nums[i]+arr[i-1];
        }
        
        for(int i=0;i<arr.length;i++)
        {   
            long avgith=  arr[i]/(i+1);
            long avgRest =  n-i-1 > 0 ? (arr[n-1] - arr[i])/(n-i-1) : 0 ;
            long avg = Math.abs(avgith - avgRest);
            if(ans > avg)
            {
                ans=avg;
                idx = i;
            }
        }
        
        return idx;
    }
}