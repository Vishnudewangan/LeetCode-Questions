class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atmostK(nums,k) - atmostK(nums,k-1);
    }
    private int atmostK(int[] nums, int k){

        int n = nums.length;

        //ds 
        int oddNumbers = 0;

        // tp
        int tail = 0, head = -1;
        int ans = 0 ; // number of subarrays with atleast k odd numbers

        while(tail < n)
        {
            while(head + 1 < n && (oddNumbers < k || nums[head+1]%2 == 0)){
                head++;

                if(nums[head]%2 == 1) oddNumbers++;

            }

            // ans

            ans += head - tail + 1;

            if(tail <= head)
            {
                if(nums[tail]%2 == 1) oddNumbers--;
                tail++;
            }
            else{
                tail++;
                head = tail - 1;
            }
        }

        return ans;
    }
}