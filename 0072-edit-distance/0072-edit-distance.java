public class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        
        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,word1.length(),word2.length(),dp);
    }
    int helper(String word1, String word2,int idx1,int idx2,int[][] dp)
    {
        if(idx1==0) return idx2;
        
        if(idx2==0) return idx1;
        
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        
        if(word1.charAt(idx1-1) == word2.charAt(idx2-1))
        {
            return dp[idx1][idx2]=helper(word1,word2,idx1-1,idx2-1,dp);
        }
        else
        {
            int a = helper(word1,word2,idx1,idx2-1,dp); // inserting 
            int b = helper(word1,word2,idx1-1,idx2,dp); // deleting
            int c = helper(word1,word2,idx1-1,idx2-1,dp); // Replace
            
            return dp[idx1][idx2]=1 + Math.min(a,Math.min(b,c));
        }
    }
}