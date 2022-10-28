//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
       
        
        return patternSearch(S.toCharArray(), pat.toCharArray());
    }
    private int prime = 101;
    
    public ArrayList<Integer> patternSearch(char[] text, char[] pattern){
        ArrayList<Integer> ans=new ArrayList<>();
        int m = pattern.length;
        int n = text.length;
        long patternHash = createHash(pattern, m - 1);
        long textHash = createHash(text, m - 1);
        for (int i = 1; i <= n - m + 1; i++) {
            if(patternHash == textHash && checkEqual(text, i - 1, i + m - 2, pattern, 0, m - 1)) {
                ans.add(i);
            }
            if(i < n - m + 1) {
                textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
            }
        }
        
        if(ans.size()==0)
        {
            ans.add(-1);
            return ans;
        }
        
        return ans;
    }
    
    private long recalculateHash(char[] str,int oldIndex, int newIndex,long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/prime;
        newHash += str[newIndex]*Math.pow(prime, patternLen - 1);
        return newHash;
    }
    
    private long createHash(char[] str, int end){
        long hash = 0;
        for (int i = 0 ; i <= end; i++) {
            hash += str[i]*Math.pow(prime,i);
        }
        return hash;
    }
    
    private boolean checkEqual(char str1[],int start1,int end1, char str2[],int start2,int end2){
        if(end1 - start1 != end2 - start2) {
            return false;
        }
        while(start1 <= end1 && start2 <= end2){
            if(str1[start1] != str2[start2]){
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }
}