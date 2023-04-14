class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int[][] dp =new int[s.length()][s.length()];
      
        
        for(int gap=0;gap<dp.length;gap++)
        {
            for(int si=0,ei=gap;ei<dp.length;si++,ei++)
            {
                if(gap==0)
                {
                    dp[si][ei]=1;
                }
                else if(gap==1)
                {
                    dp[si][ei]=s.charAt(si)==s.charAt(ei)? 2:1;
                }
                else
                {
                    dp[si][ei]=s.charAt(si)==s.charAt(ei)? 2+dp[si+1][ei-1] : Math.max(dp[si][ei-1],dp[si+1][ei]);
                }
            }
        }
        return dp[0][dp.length-1];
     
     
    }
    
    public int lps(String str, int si,int ei,int[][]dp)
    {
        if(si==ei) return 1;
        if(si>ei) return 0;
        
        if(dp[si][ei]!=-1) return dp[si][ei];
        
        if(str.charAt(si)==str.charAt(ei))
        {
            return dp[si][ei] =2+lps(str,si+1,ei-1,dp);
        }
        else
        {
            return dp[si][ei] =Math.max(lps(str,si,ei-1,dp), lps(str,si+1,ei,dp));
        }
    }
}