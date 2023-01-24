class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n= board.length;
        int steps =0;
        
        boolean[][] vis= new boolean[n][n];
        vis[n-1][0] = true;
        
        Queue<Integer> que =new ArrayDeque<>();
        que.add(1);
        
        while(que.size()>0)
        {
            int size=que.size();
            
            for(int i=0;i<size;i++)
            {
                int x = que.remove();
                
                if(x==n*n) return steps;
                
                for(int k=1; k<=6; k++)
                {    
                     if(k+x > n*n) break;
                    int[] pos =getCoordinate(k+x,n);
                    
                    int row = pos[0];
                    int col = pos[1];
                    // System.out.println(row+" " + col);
                    
                   if(vis[row][col]==true) continue;
                    
                    vis[row][col]=true;
                    
                    if(board[row][col]==-1)
                    {
                        que.add(k+x);
                    }
                    else
                    {
                        que.add(board[row][col]);
                    }
                }
            }
            steps++;
        }
        
        return -1;
        
    }
    
    int[] getCoordinate(int cellNo, int n)
    {
        int row = n - (cellNo - 1)/n - 1;
        int col = (cellNo - 1) % n; 
        
        if(n%2 == row%2)
        {
            return new int[]{row, n-col-1};
        }
        else
        {
            return new int[]{row,col};
        }
    }
}