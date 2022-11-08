class Solution {
    public long gridGame(int[][] grid) {
        
        int n= grid[0].length;
        
        if(n==1) return 0;
        
        long[][] psum =new long[2][n];
        
        psum[0][0] =  grid[0][0];
        
        for(int j=1;j<n;j++)
        {
            psum[0][j] = psum[0][j-1] + grid[0][j];
        }
        
        psum[1][0] = grid[1][0];
        
        for(int j=1;j<n;j++)
        {
            psum[1][j] = psum[1][j-1] + grid[1][j];
        }
        
        long min_sum=Long.MIN_VALUE;
        
         min_sum = Math.min(psum[0][n-1]-psum[0][0] , psum[1][n-2]);
        
        for(int j=1;j<n;j++)
        {
          long curr_sum = Math.max(psum[0][n-1] - psum[0][j], psum[1][j-1]);
            
            if(curr_sum < min_sum)
            {
                min_sum = curr_sum;
            }
        }
        
        return min_sum;
        
    }
}