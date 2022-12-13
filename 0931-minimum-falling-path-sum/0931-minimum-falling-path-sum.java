class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int ans= Integer.MAX_VALUE;
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                int uval= matrix[i-1][j];// up value;
                int ldval=j-1>=0 ? matrix[i-1][j-1]: Integer.MAX_VALUE; // left diagonal value;
                int rdval = j+1<matrix.length ? matrix[i-1][j+1] : Integer.MAX_VALUE;// right diagonal value;
                
                matrix[i][j]+= Math.min(uval, Math.min(ldval,rdval));
                
                
                    
            }
        }
        
        for(int j=0;j<matrix.length;j++)
        {
            ans=Math.min(matrix[matrix.length-1][j],ans);
        }
        
        return ans;
    }
}