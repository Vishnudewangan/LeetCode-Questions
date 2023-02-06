//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        ArrayList<ArrayList<Integer>> m1 =new ArrayList<>();
        ArrayList<ArrayList<Integer>> m2 =new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            m1.add(new ArrayList<>());
            m2.add(new ArrayList<>());
        }
        
        for(int i=0;i<A.length;i++)
        {
            addEdge(m1,A[i],A[i+1]);
           
            i++;
        }
         for(int i=0;i<B.length;i++)
        {
           
            addEdge(m2,B[i],B[i+1]);
            i++;
        }
        
        if(m1.size()!=m2.size()) return 0;
        
        
        for(int i=0;i<m1.size();i++)
        {
            Collections.reverse(m1.get(i));
            
            if(!m1.get(i).equals(m2.get(i))) return 0;
        }
        
        return 1;
        
        
        
    }
    
   static void addEdge(ArrayList<ArrayList<Integer>> m, int u, int v)
    {
        m.get(u).add(v);
    }
};