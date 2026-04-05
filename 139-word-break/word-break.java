class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> set =new HashSet<>();
   
       for(String word : wordDict) set.add(word);

       Boolean[] dp = new Boolean[s.length()+1];
        return rec(0,s,set,dp);
    }
    private static Boolean rec(int i, String s, HashSet<String> set, Boolean[] dp){
        // pruning 

        // base case
        if(s.length() == i) return true;

        // cache check
        if(dp[i] !=null) return dp[i];
        // compute
        Boolean ans = false;

        for(int j = i; j < s.length() ; j++)
        {
            if(set.contains(s.substring(i,j+1)) == true){
                ans = rec(j+1, s, set, dp);
                if(ans == true) break;
            }
        }

        // save and return

        return dp[i] = ans;

    }
}