class Solution {
    public long minimalKSum(int[] nums, int k) {

        long curr = 1;
        long sum = 0;

        Arrays.sort(nums);

        for(long val : nums)
        {   
            if(k==0) break;
            if(val > curr )
            {
                long size = Math.min(k,val - curr);

                sum += (curr+curr+size-1)*size/2;
                k-=size;
            }
            curr=val+1;
        } 

        if(k>0) sum+=(curr+curr+k-1)*k/2;

        return sum;     
    }
}