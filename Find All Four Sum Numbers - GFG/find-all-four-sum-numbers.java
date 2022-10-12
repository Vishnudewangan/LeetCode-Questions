//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
       
      Arrays.sort(nums);
        int n = nums.length;
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i < n-3;i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            ArrayList<ArrayList<Integer>> res = tsUniqueTriplets(nums,i+1,target-nums[i]);
            
            for(ArrayList<Integer>list : res) {
                list.add(nums[i]);
                Collections.sort(list);
                ans.add(list);
            }
        }
        
        return ans;
    }
    
    public  ArrayList<ArrayList<Integer>> tsUniquePairs(int[] nums, int si, int target) {
        int i = si;
        int j = nums.length - 1;

        ArrayList<ArrayList<Integer>> ans = new ArrayList < > ();

        while (i < j) {
            if (i != si && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (nums[i] + nums[j] == target) {
                ArrayList<Integer> res = new ArrayList < > ();
                res.add(nums[i]);
                res.add(nums[j]);
                ans.add(res);

                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    public  ArrayList<ArrayList<Integer>> tsUniqueTriplets(int[] nums,int si,int target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList < > ();
        int n = nums.length;

        for (int i = si; i < n - 2; i++) {

            if (i != si && nums[i] == nums[i - 1]) {
                continue;
            }

            ArrayList<ArrayList<Integer>> res = tsUniquePairs(nums, i + 1, target - nums[i]);

            for (ArrayList<Integer> list: res) {
                list.add(nums[i]);
                ans.add(list);
            }
        }

        return ans;
    }

}