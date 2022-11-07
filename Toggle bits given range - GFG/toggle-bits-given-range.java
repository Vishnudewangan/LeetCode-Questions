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
            
            int N = Integer.parseInt(S[0]);
            int L = Integer.parseInt(S[1]);
            int R = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.toggleBits(N,L,R));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int toggleBits(int N , int L , int R) {
        // code here
         for(int i=L-1;i<=R-1;i++)
        {
            N = N^1<<i;
        }

        return N;
        
    }
};