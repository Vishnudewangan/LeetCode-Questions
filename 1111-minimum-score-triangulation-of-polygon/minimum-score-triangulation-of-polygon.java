class Solution {
    public int minScoreTriangulation(int[] values) {
        return minScoreTriangulation(values,0,values.length-1,0);
    }
    int[][] dp = new int[50][50];
    
    public int minScoreTriangulation(int[] values, int i, int j, int res) {
        if (j == 0) j = values.length - 1;
        if (dp[i][j] != 0) return dp[i][j];
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res == 0 ? Integer.MAX_VALUE : res,
                minScoreTriangulation(values, i, k, 0) +
                values[i] * values[k] * values[j] +
                minScoreTriangulation(values, k, j, 0));
        }
        return dp[i][j] = res;
    }

}