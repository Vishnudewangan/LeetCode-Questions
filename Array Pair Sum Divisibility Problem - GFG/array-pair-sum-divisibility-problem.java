//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] arr, int k) {
        // Code here
        HashMap<Integer,Integer>map = new HashMap<>(); //rem vs count
        
        for(int i=0; i < arr.length;i++) {
            int rem = arr[i] % k;
            
            if(rem < 0) {
                rem += k;
            }
            
            if(map.containsKey(rem) == false) {
                map.put(rem,1);
            }
            else {
                int nf = map.get(rem) + 1;
                map.put(rem,nf);
            }
        }
        
        for(int rem : map.keySet()) {
            if(rem == 0 || (k % 2 == 0 && rem == k/2)) {
                int f = map.get(rem);
                
                if(f % 2 == 1) {
                    return false;
                } 
                else {
                    continue;
                }
            }
            
            int f1 = map.get(rem);
            int f2 = map.getOrDefault(k - rem,-1);
            
            if(f2 == -1 || f1 != f2) {
                return false;
            }
            
        }
        
        return true;
    }
}