class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        
        Queue<int[]> que =new ArrayDeque<>();
        
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1) mat[i][j]=-1;
                else que.add(new int[]{i,j});
                
            }
        }
        
        while(que.size()>0)
        {
            int[] rem=que.remove();
            
            int i=rem[0];
            int j= rem[1];
            
            for(int d=0;d<4;d++)
            {
                int ii= i+dir[d][0];
                int jj =j+dir[d][1];
                
                
                if( ii < 0 || ii>=m || jj<0 || jj>= n || mat[ii][jj]!=-1)continue;
                
                    que.add(new int[]{ii,jj});
                    
                    mat[ii][jj] = mat[i][j] + 1;
                
            }
        }
        
        return mat;
       
    }
}