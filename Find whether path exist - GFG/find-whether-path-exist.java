//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int row=0,col=-1;
        
        l1 :for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    row=i;
                    col = j;
                    
                    break l1;
                }
            }
        }
        
       return helper(grid,row,col);
    }
    
    boolean helper(int[][] grid,int i,int j)
    {     
       
        if(i>=0 && i<=grid.length-1 && j>=0 && j<=grid[0].length-1 && grid[i][j]!=0 && grid[i][j]!=-1)
        {    if(grid[i][j]==2)return true;
        
              grid[i][j] =-1;
            boolean u= helper(grid,i-1,j);
             
             if(u)
             {
                 return true;
             }
             
             boolean r = helper(grid,i,j+1);
             if(r) return true;
             
             boolean d = helper(grid,i+1,j);
             if(d) return true;
             
             boolean l = helper(grid,i,j-1);
             if(l ) return true;
             
             grid[i][j]=3;
        }
        
        return false;
    }
}