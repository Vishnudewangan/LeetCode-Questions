class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!=word.charAt(0))continue;
                
                boolean res = explore(board,i,j,0,word);
                
                if(res) return true;
            }
        }
        
        return false;
    }
    int[][] dir ={{-1,0},{0,1},{1,0},{0,-1}};
    boolean explore(char[][] board , int i, int j,int si, String word)
    {
        if(si==word.length()) return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length ) return false;
        
        if(board[i][j]!=word.charAt(si)) return false;
         
         char myChar = board[i][j];
        
          board[i][j] ='@';
        
        for(int d=0;d<4;d++)
        {
            boolean res = explore(board,i+dir[d][0] ,j+dir[d][1],si+1,word);
           if(res==true) {
                board[i][j] = myChar;
                return true;
            }
        }
        
        board[i][j] = myChar;
        
        return false;
        
    }
}