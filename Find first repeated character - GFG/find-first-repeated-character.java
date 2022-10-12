//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) 
    { 
        HashSet<Character> hs =new HashSet<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(hs.contains(s.charAt(i))==true)
            {
                return s.charAt(i)+"";
            }
            else
            {
                hs.add(s.charAt(i));
            }
        }
        
        return "-1";
    }
} 