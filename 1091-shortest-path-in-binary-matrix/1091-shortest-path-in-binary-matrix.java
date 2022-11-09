class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] == 1 || grid[m-1][n-1]== 1) return -1;
        
        int ans= 0;
        
        boolean[][] vis=new boolean[m][n];
        
        Queue<int[]> que =new ArrayDeque<>();
        
        que.add(new int[]{0,0});
        
        vis[0][0] =true;
        
        while(que.size()>0)
        {
            int size=que.size();
            
            for(int i=0;i<size;i++)
            {
                int[] rem = que.remove();
                
                int x = rem[0];
                int y = rem[1];
                
                if(x==m-1 && y==n-1)
                {
                    return ans+1;
                }
                
                for(int d=0;d<8;d++)
                {
                    int xx = x+dir[d][0];
                    int yy = y+dir[d][1];
                    
                    if(xx>=0 && xx<m && yy>=0 && yy<n && vis[xx][yy] == false && grid[xx][yy] == 0 )
                    {
                        que.add(new int[]{xx,yy});
                        vis[xx][yy] =true;
                    }
                }
            }
            ans++;
        }
        
        return -1;
    }
}