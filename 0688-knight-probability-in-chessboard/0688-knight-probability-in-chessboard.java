class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
         int[][] moves= {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        
        double[][] dp1=new double[n][n]; // prev
        double[][] dp2 =new double[n][n]; // new
        
        dp1[row][column] = 1.0;
        
        for(int l=0;l<k;l++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dp1[i][j] >0)
                    {
                        for(int m=0;m<8 ;m++)
                        {
                            int ni=i+moves[m][0];
                            int nj = j+moves[m][1];
                            
                            
                            if(ni>=0 && ni<n && nj>=0 && nj<n)
                            {
                                dp2[ni][nj]+=dp1[i][j]/8.0;
                            }
                        }
                    }
                }
            }
            
            dp1=dp2;
            dp2=new double[n][n];
        
        }
        
        double ans =0.0;
        
        for(double[]  arr: dp1)
        {
            for(double val : arr)
            {
                ans+=val;
            }
        }
        
        return ans;
        
         
    }
}