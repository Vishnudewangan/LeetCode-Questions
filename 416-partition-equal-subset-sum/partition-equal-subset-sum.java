class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if(sum%2 == 1) return false;

        int [][] dp = new int[nums.length + 100][100100];

        for(int[] arr : dp) Arrays.fill(arr, -1);

        return rec(0,sum/2,nums,dp) == 1 ? true : false;
    }

    static int rec(int level, int sum_left,int[] nums,int[][] dp){
        // pruning

        // base case
        if(level == nums.length)
        {
            if(sum_left == 0) return 1;
            else return 0;
        }
        // cache check

        if(dp[level][sum_left] != -1) return dp[level][sum_left];
        // compute/transition
        
        int ans = rec(level+1, sum_left,nums,dp);
        
        if(nums[level] <= sum_left) ans  =ans |rec(level+1 , sum_left - nums[level], nums,dp);


        // save and return

        return dp[level][sum_left] = ans;
    }
}