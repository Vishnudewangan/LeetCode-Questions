class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        boolean[][] dp=new boolean[n][n];
        
        int strt=-1,end=-1;
        int len = 0;
        
        for(int gap=0;gap<n;gap++)
        {
            for(int si=0,ei=gap ; ei<n;ei++,si++)
            {
                if(gap==0)
                {
                    dp[si][ei]=true;
                }
                else if(gap==1)
                {
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei]=true;
                    }
                    else
                    {
                        dp[si][ei] = false;
                    }
                }
                else
                {
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei] = dp[si+1][ei-1];
                    }
                    else
                    {
                        dp[si][ei] = false;
                    }
                }
                
                if(dp[si][ei]==true && gap+1>len)
                {
                     strt = si;
                     end = ei;
                    len = gap+1;
                }
                
             
            }
            
            
        }
        
        return s.substring(strt,end+1);
    }
}