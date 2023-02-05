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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{     
    int[][] dirs = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<int[]> que =new ArrayDeque<>();
        
        que.add(new int[]{KnightPos[0]-1, KnightPos[1]-1});
        
        boolean[][] vis =new boolean[N][N];
        
        
        int steps = 0;
        
        while(que.size()>0)
        {
            int size=que.size();
            
            for(int i=0;i<size;i++)
            {
                int[] rem =que.remove();
                
                int row = rem[0];
                int col = rem[1];
                
                if(row==TargetPos[0]-1 && col==TargetPos[1]-1) return steps;
                
                if(vis[row][col]==true) continue;
                
                vis[row][col]=true;
                
                for(int[] dir : dirs)
                {
                    int rr = row + dir[0];
                    int cc = col + dir[1];
                    
                    if(rr>=0 && rr<N && cc>=0 &&cc< N && vis[rr][cc]==false)
                    {
                        que.add(new int[]{rr,cc});
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}