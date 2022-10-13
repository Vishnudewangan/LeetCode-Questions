//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {    int[][] dp=new int[N][N];
    
        for(int[] arr: dp)
        {
            Arrays.fill(arr,-1);
        }
         int max = Integer.MIN_VALUE;
        for(int j=0;j<N;j++)
        {
            max = Math.max(max,helper(Matrix,0,j,dp));
        }
        
        return max;
    }
    
    static int helper(int[][] grid, int row,int col,int[][] dp)
    {
        if( row>=grid.length || col<0 || col>=grid.length)
        {
            return 0;
        }
        
         if(dp[row][col]!=-1) return dp[row][col];
        
        int f1 = helper(grid,row+1,col,dp);
        int f2 = helper(grid,row+1,col-1,dp);
        int f3 = helper(grid,row+1,col+1,dp);
        
        return dp[row][col]=Math.max(f1,Math.max(f2,f3))+ grid[row][col];
    
    }
    
    
}