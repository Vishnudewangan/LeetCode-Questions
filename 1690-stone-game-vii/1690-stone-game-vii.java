class Solution {
    int[] preSum;
    Integer[][] dp ;
    public int stoneGameVII(int[] stones) {
         preSum = new int[stones.length+1];
         dp = new Integer[stones.length][stones.length];
        for(int i=0;i<stones.length;i++)
        {
            preSum[i+1] = stones[i]+preSum[i];
        }
        return helper(stones,0, stones.length-1);
    }
    
    private int getScore(int left, int right)
    {
      return preSum[right+1] - preSum[left];
    }
    
    private int helper(int[] stones,int left,int right)
    {    
        if(left > right) return 0;
        
        if(dp[left][right]!=null) return dp[left][right];
        int lans = getScore(left+1,right) - helper(stones,left+1,right);//  chooses  left;
        int rans = getScore(left,right-1) - helper(stones,left, right-1);//chooses right;
        
        return dp[left][right]=Math.max(lans, rans);
    }
    
    
    
    
    
    
    
}