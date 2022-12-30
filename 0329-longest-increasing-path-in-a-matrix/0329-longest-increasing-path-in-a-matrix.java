class Solution {
    public int longestIncreasingPath(int[][] matrix) {
       int olen=0;
          
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int[] a : dp) Arrays.fill(a,-1);
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {   
               int max= dfs(i,j,matrix,Integer.MIN_VALUE,dp);
             
              olen=Math.max(olen,max);
               
            }
        }
        
        return olen;
    }
    
    int dfs(int i,int j,int[][] matrix,int prevMax,int[][] dp)
    {
        
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=prevMax)
        {
            return 0;
        }
         
        if(dp[i][j]!=-1) return dp[i][j];
         
       
        int val=matrix[i][j];
       
        
       int top   = dfs(i-1,j,matrix,val,dp);
       int right = dfs(i,j+1,matrix,val,dp);
       int bottom =  dfs(i+1,j,matrix,val,dp);
       int left =   dfs(i,j-1,matrix,val,dp);
        
        
       
        
        return dp[i][j] =max(top,right,bottom,left)+1;  // +1 for self;
        
        
    }
    
    int max(int...arr)
    {
        int mx = arr[0];
        
        for(int val: arr)
        {
            mx =Math.max(val,mx);
        }
        return mx;
    }
}