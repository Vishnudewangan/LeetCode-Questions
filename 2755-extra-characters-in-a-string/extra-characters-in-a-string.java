class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set =new HashSet<>();

        for(String str : dictionary) set.add(str);

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);

        return rec(0,s,set,dp);
    }

    int rec(int i, String s, HashSet<String> set, int[] dp){
       // pruning
       //base case
       if(i == s.length()) return 0;

       // cache check
       if(dp[i] != -1) return dp[i];
       // compute/ transition

       int ans = (int)1e9;
       
       for(int j = i; j < s.length(); j++)
       {   int subAns = set.contains(s.substring(i,j+1))  ? 0 : s.substring(i,j+1).length();
           ans = Math.min(ans, rec(j+1,s,set,dp) + subAns);
       }

       // save and return
       return dp[i] = ans;
    }
}