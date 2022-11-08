class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans =new ArrayList<>();
        
        if(heights.length==0 || heights[0].length==0) return ans;
        
        
        boolean[][] pacific=new boolean[heights.length][heights[0].length];
         boolean[][] atlantic=new boolean[heights.length][heights[0].length];
        
        // dfs
        
        // top bottom row-> constant
        
        for(int c=0;c<heights[0].length;c++)
        {
                  dfs(0,c,heights, pacific,Integer.MIN_VALUE);
                  dfs(heights.length-1, c,heights,atlantic , Integer.MIN_VALUE);
        }
        
        // left , right  col -> constant
        
        for(int r=0;r<heights.length;r++)
        {
            dfs(r,0,heights,pacific,Integer.MIN_VALUE);
            dfs(r,heights[0].length-1,heights,atlantic,Integer.MIN_VALUE);
            
        }
        
        // find location
        
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                
                if(pacific[i][j]==true && atlantic[i][j]==true)
                {  List<Integer> list=new ArrayList<>();
                   list.add(i);
                    list.add(j);
                  ans.add(list);
                }
                
               
            }
        }
        
        return ans;
    }
    
    void dfs(int row, int col, int[][] heights, boolean[][] matrix, int prev)
    {
        if(row< 0 || row>=heights.length || col<0 || col>=heights[0].length)
        {
            return;
        }
        else if(matrix[row][col]==true)
        {
            return ;
        }
        else if(heights[row][col] < prev)
        {
            return;
        }
        
        matrix[row][col] = true;
        
        // top
          dfs(row-1,col,heights,matrix,heights[row][col]);
        // bottom
          dfs(row+1,col,heights,matrix,heights[row][col]);
        // left 
            dfs(row,col-1,heights,matrix,heights[row][col]);
        
        // right
        dfs(row,col+1,heights,matrix,heights[row][col]);
    }
}