class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] prefixSum = new int[m+1][n+1];
        
        int res = 0;
        int len =1;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + mat[i-1][j-1];
                
                if(i>=len && j>=len && prefixSum[i][j]  - prefixSum[i-len][j] - prefixSum[i][j-len] + prefixSum[i-len][j-len] <= threshold)
                {
                    res = len++;
                }
            }
        }
        return res;
    }
}