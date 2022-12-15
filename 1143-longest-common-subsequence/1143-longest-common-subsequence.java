class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        //***recursion + memoization***//
        
        
//         int[][] dp=new int[text1.length()][text2.length()];
        
//         for(int[] arr : dp)
//         {
//             Arrays.fill(arr,-1);
//         }
//         return helper(text1,text2,0,0,dp);
        
//     }
    
//     int helper(String str1,String str2,int idx1,int idx2,int[][] dp)
//     {
//         if(idx1==str1.length() || idx2==str2.length())
//         {
//             return 0;
//         }
        
//          if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//         if(str1.charAt(idx1)==str2.charAt(idx2))
//         {
//             return dp[idx1][idx2]= 1+helper(str1,str2,idx1+1,idx2+1,dp);
//         }
//         else{
            
//             return dp[idx1][idx2]= Math.max(helper(str1,str2,idx1+1,idx2,dp),helper(str1,str2,idx1,idx2+1,dp));
//         }
        
        //****** Tabulation *****//
        
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        
       
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
        
    }
}