//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        if(N==0) return 0;
        if(N<=2) return 1;
        
        return helper(Integer.toBinaryString(N));
        
    }
    
    static int helper(String str)
    {
        
       int maxAns = str.charAt(0)=='1' ? 1 : 0;
       int ans =maxAns;
       
       for(int i=1;i<str.length();i++)
       {
           
           
          
          if(str.charAt(i)=='0')
          {
              ans=0;
          }
          else if(str.charAt(i)=='1')
          {
              ans+=1;
          }
          maxAns = Math.max(maxAns , ans);
          
         
       }
       
       return maxAns;
        
        
    }
}



//{ Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends