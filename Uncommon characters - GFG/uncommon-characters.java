//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        
       HashSet<Character> set1 =new HashSet<>();
        
        for(char ch : A.toCharArray())
        {
            set1.add(ch);
        }
        HashSet<Character> set2 =new HashSet<>();
        for(char ch : B.toCharArray())
        {
           set2.add(ch);
           
        }
        
        StringBuilder sb =new StringBuilder();
        for(char ch : set1)
        {
            if(set2.contains(ch)==false)
            {
                sb.append(ch);
            }
        }
        
        for(char ch : set2)
        {
            if(set1.contains(ch)==false)
            {
                sb.append(ch);
            }
        }
        
        String str = sb.toString();
        char[] chArr = str.toCharArray();
        
        Arrays.sort(chArr);
        
        return chArr.length==0 ?"-1" : new String(chArr);
    }
}