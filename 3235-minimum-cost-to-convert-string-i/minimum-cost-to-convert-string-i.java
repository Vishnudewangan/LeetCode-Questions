class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        int[][] dp =new int[26][26];

        for(int[] arr :dp)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        for(int i=0;i<26;i++)
        {
            dp[i][i] = 0;
        }

        for(int i=0;i<cost.length;i++)
        {
            dp[original[i]-'a'][changed[i]-'a'] = Math.min(dp[original[i]-'a'][changed[i]-'a'],cost[i]);
        }

        for(int k=0;k<26;k++)
        {
            for(int i=0;i<26;i++)
            {
                if(dp[i][k]!=Integer.MAX_VALUE)
                {
                    for(int j=0;j<26;j++)
                    {
                        if(dp[k][j]!=Integer.MAX_VALUE && dp[i][k]+dp[k][j] < dp[i][j])
                        {
                           dp[i][j] = dp[i][k]+dp[k][j];
                        }
                    }
                }
            }
        }
        long ans=0l;
        for(int i=0;i<source.length();i++)
        {
            if(dp[source.charAt(i)-'a'][target.charAt(i)-'a']==Integer.MAX_VALUE) return -1l;
            ans+=dp[source.charAt(i)-'a'][target.charAt(i)-'a'];   
        }
        return ans;
    }
}