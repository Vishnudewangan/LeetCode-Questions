class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        return rec(0,arr, k,dp);

    }
    private static int rec(int i,int[] arr, int k, int[] dp)
    {
      // prunning

      // basecase
      if(arr.length == i) return 0;

      // cache check

      if(dp[i] != -1) return dp[i];
      // compute/transistion

      int ans = 0;
      int mx = 0;
      for(int j = i; j < Math.min(arr.length, i + k); j++)
      {
             mx = Math.max(arr[j], mx);

             ans = Math.max(ans,  mx * (j-i+1) + rec(j+1, arr , k,dp));
      }

      // save and return
      return dp[i] = ans;
    }
}