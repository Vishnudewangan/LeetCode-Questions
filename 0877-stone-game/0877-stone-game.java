class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        dp=new int[piles.length][piles.length];
         int sum=0;
        for(int val : piles)sum+=val;
        int alice= helper(piles,0,piles.length-1);
        return alice >sum-alice;
    }
    
    int helper(int[] piles,int left, int right)
    {
        if(left  > right) return 0;
        if(dp[left][right]!=0) return dp[left][right];
        int op1  = piles[left] + Math.min(helper(piles,left+1,right-1),helper(piles,left+2,right));
        int op2  = piles[right] + Math.min(helper(piles,left+1,right-1),helper(piles,left,right-2));
        
        return dp[left][right]=Math.max(op1,op2);
    }
}