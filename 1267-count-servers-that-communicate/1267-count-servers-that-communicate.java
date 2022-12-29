class Solution {
  
    public int countServers(int[][] grid) {
        
        int m = grid.length;
        int n= grid[0].length;
       
        
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }
        
        int resCnt=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && (rowCnt[i]>1 || colCnt[j]>1))
                {
                    resCnt++;
                }
            }
        }
        
        return resCnt;
    }
}