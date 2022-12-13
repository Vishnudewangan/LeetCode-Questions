class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int ans= Integer.MAX_VALUE;
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
               
                matrix[i][j]+= Math.min(matrix[i-1][j], Math.min(matrix[i-1][Math.max(0,j-1)],matrix[i-1][Math.min(matrix.length-1,j+1)]));
                
                
                    
            }
        }
        
        for(int j=0;j<matrix.length;j++)
        {
            ans=Math.min(matrix[matrix.length-1][j],ans);
        }
        
        return ans;
    }
}