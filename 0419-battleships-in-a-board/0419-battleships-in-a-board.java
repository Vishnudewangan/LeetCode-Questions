class Solution {
    public int countBattleships(char[][] board) {
        
        boolean[][] vis =new boolean[board.length][board[0].length];
        int cnt =0;
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 'X' && vis[i][j]== false)
                {
                    dfs(i,j,board,vis);
                    cnt++;
                }
            }
        }
        
        return cnt;
        
        
    }
    
    void dfs(int i, int j,char[][] board, boolean[][] vis)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j]==true || board[i][j]!='X')
        {
            return ;
        }
        
        vis[i][j] = true;
        
        dfs(i-1,j,board,vis);
        dfs(i,j+1,board,vis);
        dfs(i+1,j,board,vis);
        dfs(i,j-1,board,vis);
        
        
    }
}