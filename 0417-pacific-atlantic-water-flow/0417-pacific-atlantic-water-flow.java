class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> ans =new ArrayList<>();
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][]  pacific=new  boolean[m][n];
        boolean[][]  atlantic=new  boolean[m][n];
        
        for(int c=0;c<n;c++)
        {
            dfs(0,c,Integer.MIN_VALUE,heights,pacific);
            dfs(m-1,c,Integer.MIN_VALUE,heights,atlantic);
        }
        
        for(int r=0;r<m;r++)
        {
            dfs(r,0,Integer.MIN_VALUE,heights,pacific);
            dfs(r,n-1,Integer.MIN_VALUE,heights,atlantic);
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pacific[i][j]==true && atlantic[i][j]==true)
                {
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        
        return ans;
    }
    
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    
    void dfs(int r, int c ,int prev, int[][] heights,boolean[][] mat)
    {
        if(r<0 || c< 0 || r>=mat.length || c>=mat[0].length)return;
        
        if(mat[r][c]== true || heights[r][c] < prev) return ;
        
        mat[r][c] =true;
        
        for(int d=0;d<4;d++)
        {
            dfs(r+dir[d][0], c+dir[d][1], heights[r][c],heights,mat);
        }
    }
}