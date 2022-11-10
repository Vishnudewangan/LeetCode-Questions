class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m= maze.length , n = maze[0].length;
        int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};
        int er=entrance[0], ec =entrance[1];
         maze[er][ec] = '+';
        
        Queue<int[]> que=new ArrayDeque<>();
        que.add(new int[]{er,ec,0});
        
        while(que.size()>0)
        {
            int[] rem = que.remove();
            
            int r = rem[0];
            int c = rem[1];
            int currDist = rem[2];
            
            for(int d=0;d<4;d++)
            {
                int rr= r+dir[d][0];
                int cc= c+dir[d][1];
                
                if(rr>=0 && rr<m && cc>=0 && cc< n && maze[rr][cc]=='.')
                {
                    if(rr== 0 || rr==m-1 || cc == 0 || cc == n-1) return currDist+1;
                    
                    maze[rr][cc] = '+';
                    que.add(new int[]{rr,cc,currDist+1});
                    
                }
            }
            
        }
        
        return -1;
    }
}