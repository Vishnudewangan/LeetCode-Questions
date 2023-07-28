class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        
        
        int[][] dp =new int[nums.length][nums.length];
        
        for(int[] arr : dp) Arrays.fill(arr,-1);
        
        int player1Score = optimalStrategyForGame(nums, 0,nums.length-1,dp);
        
       return player1Score >=sum-player1Score ;
            
        
    }
    
    int optimalStrategyForGame(int[] nums, int si,int ei, int[][] dp)
    {
        if(si > ei) return 0;
        
        if(dp[si][ei] != -1)
        {
            return dp[si][ei];
        }
        
        int f1 = nums[si] + Math.min(optimalStrategyForGame(nums,si+1,ei-1,dp),optimalStrategyForGame(nums,si+2,ei,dp));
        int f2 = nums[ei] + Math.min(optimalStrategyForGame(nums,si,ei-2,dp), optimalStrategyForGame(nums,si+1,ei-1,dp));
        
        return dp[si][ei] = Math.max(f1,f2);
    }
}