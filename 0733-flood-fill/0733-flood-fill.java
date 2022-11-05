class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        boolean[][] vis = new boolean[image.length][image[0].length];
        dfs(image,sr,sc,image[sr][sc],color,vis);
        
        return image;
    }
    
    void dfs(int[][] grid,int sr, int sc, int oclr,int clr , boolean[][] vis)
    {
        if(sr<0 || sc < 0 || sr>=grid.length || sc>=grid[0].length || vis[sr][sc]==true || grid[sr][sc]!=oclr)
        {
            return;
        }
        vis[sr][sc] = true;
        grid[sr][sc] = clr;
        
        dfs(grid,sr-1,sc,oclr,clr,vis);
        dfs(grid,sr,sc+1,oclr,clr,vis);
        dfs(grid,sr+1,sc,oclr,clr,vis);
        dfs(grid,sr,sc-1,oclr,clr,vis);
        
        
    }
    
}