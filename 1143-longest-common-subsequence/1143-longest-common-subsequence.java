class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        
        for(int[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(text1,text2,0,0,dp);
        
    }
    
    int helper(String str1,String str2,int idx1,int idx2,int[][] dp)
    {
        if(idx1==str1.length() || idx2==str2.length())
        {
            return 0;
        }
        
         if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(str1.charAt(idx1)==str2.charAt(idx2))
        {
            return dp[idx1][idx2]= 1+helper(str1,str2,idx1+1,idx2+1,dp);
        }
        else{
            
            return dp[idx1][idx2]= Math.max(helper(str1,str2,idx1+1,idx2,dp),helper(str1,str2,idx1,idx2+1,dp));
        }
        
        
    }
}