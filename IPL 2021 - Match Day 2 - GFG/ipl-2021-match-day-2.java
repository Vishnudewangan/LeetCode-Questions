//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        
        int[] ngeor = nextGreatestElementOnRight(arr);
        
        
        ArrayList<Integer> ans =new ArrayList<>();
        
        for(int i=0;i<=n-k;i++)
        {
            int j=i;
            
            while(ngeor[j] < i+k)
            {
                j = ngeor[j];
            }
            
            ans.add(arr[j]);
        }
        
        return ans;
    }
    
    static int[] nextGreatestElementOnRight(int[] arr)
    {
        Stack<Integer> st =new Stack<>();
        
        int[] nge = new int[arr.length];
        
        nge[arr.length-1] = arr.length;
        
        st.push(arr.length-1);
        
        for(int i=arr.length-2;i>=0;i--)
        {
            while(st.size() > 0 && arr[st.peek()]<= arr[i])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                nge[i] = arr.length;
            }
            else
            {
                nge[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return nge;
    }
}