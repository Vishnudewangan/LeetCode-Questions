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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {  int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int fo=0;
        
        Queue<int[]> que=new ArrayDeque<>();
        
       
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                {
                    que.add(new int[]{i,j,0});
                }
                else if(grid[i][j] == 1)
                {
                    fo++;
                }
            }
        }
        
        
        if(fo==0) return 0;
        
       
        
        while(que.size()>0)
        {   
           
              int[] point = que.remove();
              
              int row = point[0];
              int col = point[1];
              int t  = point[2];
              
             if(grid[row][col]==-1)
             {
                 continue;
             }
             else if(grid[row][col]==1)
             {
                 fo--;
             }
             
             grid[row][col]=-1;
              
             
              if(fo==0) 
              {
                  return t;
              }
             
             
            
              
              for(int i=0;i<4;i++)
              {
                 int rr= row + dir[i][0];
                 int cc =col + dir[i][1];
                 
                 if(rr>=0 && rr<grid.length && cc>=0 && cc<grid[0].length && grid[rr][cc]== 1 )
                 {
                     que.add(new int[]{rr,cc,t+1});
                    
                     
                 }
              }
                
            
            
            
        }
         
        return -1;
    }
}