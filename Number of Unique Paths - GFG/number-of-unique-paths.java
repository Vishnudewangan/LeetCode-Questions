//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        
        return helper(a,b,0,0);
    }
    
   static  int helper(int m,int n, int i,int j)
    {
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        
        int f1 = helper(m,n,i+1,j);
        int f2= helper(m,n,i,j+1);
        
        return f1+f2;
    }
}