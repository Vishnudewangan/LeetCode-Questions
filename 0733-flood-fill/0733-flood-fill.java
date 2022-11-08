class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     
        int clr = image[sr][sc];
        
                  dfs(sr,sc,clr,image,newColor);
     
        
        return image;
    }
    
    void dfs(int i,int j,int clr,int[][] grid,int newColor)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=clr  || grid[i][j]==newColor)
        {
            return ;
        }
        
        grid[i][j] = newColor;
        
        dfs(i-1,j,clr,grid,newColor);
        dfs(i,j+1,clr,grid,newColor);
        dfs(i+1,j,clr,grid,newColor);
        dfs(i,j-1,clr,grid,newColor);
    }
}