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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	
	static class Pair implements Comparable<Pair>{
	    int wsf;
	    int row;
	    int col;
	    
	    Pair(int wsf, int row, int col)
	    {
	        this.wsf= wsf;
	        this.row = row;
	        this.col=col;
	    }
	    
	    public int compareTo(Pair o)
	    {
	        return this.wsf - o.wsf;
	    }
	}
	
	int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int minimumCostPath(int[][] grid)
    {
          PriorityQueue<Pair> pq =new PriorityQueue<>();
          
         int ans = Integer.MAX_VALUE;
         boolean[][] vis=new boolean[grid.length][grid[0].length];
        //  int[][] dp = new int[grid.length][grid[0].length];
         
        //  for(int[] arr: dp)
        //  {
        //      Arrays.fill(arr,Integer.MAX_VALUE);
        //  }
         
        //  dp[0][0] = grid[0][0];
          
         pq.add(new Pair(grid[0][0],0,0));
          
          vis[0][0]=true;
          
          while(pq.size()>0)
          {
              // remove;
              
              Pair rem =pq.remove();
              
              int wsf =rem.wsf;
              int r = rem.row;
              int c = rem.col;
              
              
              if(r==grid.length-1 && c==grid[0].length-1)
              {
                  ans =Math.min(wsf,ans);
              }
              
             
              for(int i=0;i<4;i++)
              {
                  int rr= r+ dir[i][0];
                  int cc= c + dir[i][1];
                  
                  if(rr>=0 && rr<grid.length && cc>=0 && cc<grid[0].length && vis[rr][cc]==false )
                  {   
                    //   if(vis[rr][cc]==false )
                    //   {
                      
                         vis[rr][cc] = true;
                         pq.add(new Pair(wsf+grid[rr][cc],rr,cc));
                      
                    //   }
                    // //   
                    //   dp[rr][cc] = Math.min(dp[rr][cc], wsf+grid[rr][cc]);
                  }
              }
            
          }
          
        //   return dp[grid.length-1][grid.length-1];
        
        return ans;
    }
}