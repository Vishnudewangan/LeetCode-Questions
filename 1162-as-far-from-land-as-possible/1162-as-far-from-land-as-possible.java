class Solution {
    public int maxDistance(int[][] grid) {
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dist =new int[m][n];
        
        int steps =-1;
        
        
        Queue<int[]> que=new ArrayDeque<>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    que.add(new int[]{i,j});
                }
            }
        }
        
        while(que.size()>0)
        {
            int[] curr = que.remove();
            
            for(int i=0;i<4;i++)
            {
                int xx = curr[0] + dir[i][0];
                int yy = curr[1] + dir[i][1];
                
                if(xx>=0 && xx< m && yy>=0 && yy< n && grid[xx][yy]==0 && dist[xx][yy] ==0)
                {
                    dist[xx][yy] = dist[curr[0]][curr[1]] +1;
                    que.add(new int[]{xx,yy});
                    steps = Math.max(steps,dist[xx][yy]);
                }
            }
        }
        
        return steps;
    }
}