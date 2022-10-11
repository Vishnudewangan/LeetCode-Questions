//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }
            
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String nextPalin(String N) 
    {   
        int n = N.length();
        int[] arr =new int[n/2];
        
        for(int i=0;i< n/2;i++)
        {
            arr[i] = N.charAt(i) -'0';
        }
        
        boolean isPossible = nextPermutation(arr);
         
         if(isPossible==false) return "-1";
         
         StringBuilder sb =new StringBuilder();
         
         for(int val : arr)
         {
             sb.append(val+"");
         }
         
         StringBuilder ans =new StringBuilder("");
         if(n%2==1)
         {
             return ans.append(sb).append(N.charAt(n/2)).append(sb.reverse()).toString();
         }
         else
         {
             return ans.append(sb).append(sb.reverse()).toString();
         }
         
    }
    
    boolean nextPermutation(int[] arr)
    {
        int n = arr.length;
        
       int i = n-2;
        
        while(i>=0 && arr[i+1]<=arr[i])
        {
            i--;
        }
        
        if(i<0) return false;
        
        int j=n-1;
        
       while(j>=0 && arr[j]<=arr[i])
       {
             j--;
       }
        
        swap(arr,i,j);
        
        
        reverse(arr,i+1);
        
        return true;
        
        
    }
    
    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void reverse(int[] arr, int i)
    {
        int j= arr.length-1;
        
        while(i< j)
        {
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
             
             i++;
             j--;
        }
        
        
    }
}
