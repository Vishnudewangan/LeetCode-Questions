class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
         int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m ^ j < n) {
                sb.append(i < m ? s1.charAt(i++) : s2.charAt(j++));
            }else if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i++));
                ++j;
            }else {
                sb.append(dp[i + 1][j] > dp[i][j + 1] ? s1.charAt(i++) : s2.charAt(j++));
            }
        }
        return sb.toString();
    }
    
}