//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here
        
        int minSum= a[0];
        int currSum=a[0];
        
        for(int i=1;i<size;i++)
        {
            if(currSum>0)
            {
                currSum= a[i];
            }
            else
            {
                currSum+=a[i];
            }
            
            minSum= Math.min(currSum,minSum);
        }
        
        return minSum;
    }
}