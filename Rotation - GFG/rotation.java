//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        
        int lo=0, hi =n-1;
        
        if(arr[lo]<=arr[hi])
        {
            return 0;
        }
        
        while(lo<=hi)
        {
            int mid = lo + (hi - lo)/2;
            
            if(arr[mid]> arr[mid+1])
            {
                return mid+1;
            }
            else if(arr[mid-1]> arr[mid])
            {
                return mid;
            }
            
            if(arr[lo]<=arr[mid])
            {
                lo=mid+1;
            }
            else if(arr[mid]<=arr[hi])
            {
                hi = mid-1;
            }
        }
        return -1;
    }
}