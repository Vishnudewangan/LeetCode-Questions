class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       
       return helper(nums,goal) - helper(nums,goal - 1); 

    }
    // this will return no. of subarrays whose sum are <= goal
    private int helper(int[] nums,int goal){

        if(goal < 0) return 0;
        int n = nums.length;
        // ds
        int sum = 0;

        int tail = 0, head = -1;
        int ans = 0;

        while(tail < n)
        {
            while(head + 1 < n && (nums[head+1] == 0 || sum < goal)){
                head++;
                if(nums[head]  == 1) sum+=1;
            }
            // ans

            ans += head - tail + 1;

            if(tail<=head){

                if(nums[tail] == 1) sum -= 1;

                tail++;
            }
            else{// reset
                tail++;
                head = tail -1;
            }
        }
        return ans;
    }
}