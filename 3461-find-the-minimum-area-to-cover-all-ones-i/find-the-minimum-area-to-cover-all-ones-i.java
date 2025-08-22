class Solution {
    public int minimumArea(int[][] grid) {
        
        int strow = Integer.MAX_VALUE;
        int endrow = Integer.MIN_VALUE;
        
        int stcol = Integer.MAX_VALUE;
        int endcol = Integer.MIN_VALUE;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    strow = Math.min(i,strow);
                    endrow = Math.max(i,strow);
                    stcol = Math.min(j,stcol);
                    endcol = Math.max(j,endcol);
                }
            }
        }
        
        return (endrow - strow+1)*(endcol - stcol+1);
    }
}