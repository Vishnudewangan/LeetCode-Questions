class Solution {
    public int minCut(String s) {
        
        boolean[][] dp=new boolean[s.length()][s.length()];
        
        for(int gap=0;gap<dp.length;gap++)
        {
            for(int si=0,ei=gap; ei<dp.length;si++,ei++)
            {
                if(gap==0)
                {
                    dp[si][ei]=true;
                }
                else if(gap==1)
                {
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei] = true;
                    }
                }
                else
                {
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei]=dp[si+1][ei-1];
                    }
                }
            }
        }
        
        int[] dp2=new int[s.length()];
        
           
         for(int i=dp2.length-2;i>=0;i--)
         {
             if(dp[i][s.length()-1]==true)
             {
                 dp2[i]=0;
                 continue;
             }
            
                 int min=Integer.MAX_VALUE;
                 
                 for(int j=i; j<dp.length-1 ;j++)
                 {  
                     if(dp[i][j]==true)
                     min=Math.min(min, dp2[j+1]);
                 }
             
                  dp2[i]=min+1;
         }
        
        return dp2[0];
    }
}