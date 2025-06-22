class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp =new boolean[s.length()][s.length()];
         
         int ssi=-1,sei = -1;
         int len =0;
        for(int gap=0;gap<dp.length;gap++)
        {
            for(int si=0,ei=gap;ei<dp.length;si++,ei++)
            {
                if(gap==0)
                {
                    dp[si][ei] = true;
                }
                else if(gap==1)
                {
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei] = true;
                    }
                    else
                    {
                        dp[si][ei] = false;
                    }
                }
                else
                {
                    if(s.charAt(si)== s.charAt(ei))
                    {
                        dp[si][ei] = dp[si+1][ei-1];
                    }
                    else
                    {
                        dp[si][ei] = false;
                    }
                }

                if(dp[si][ei]==true && gap+1 > len)
                {
                    ssi = si;
                    sei = ei;
                    len = gap+1;
                }
            }
        }
        return s.substring(ssi,sei+1);
    }
}