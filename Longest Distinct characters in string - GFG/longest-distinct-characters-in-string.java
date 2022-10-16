//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        
         HashMap<Character,Integer> map=new HashMap<>();
        //  HashSet<Character> set =new HashSet<>();
         
        //  for(int i=0;i<S.length();i++)
        //  {
        //      set.add(S.charAt(i));
        //  }
         
         
         int i=-1,j=-1, omax=Integer.MIN_VALUE;
         
         while(i< S.length()-1)
         {
             while(i<S.length()-1 )
             {
                 i++;
                 
                char ch = S.charAt(i);
                 map.put(ch,map.getOrDefault(ch,0)+1);
                 
                 if(map.get(ch)==2)
                 {
                     break;
                 }
                 else
                 {
                     int len = i-j;
                     
                     omax = Math.max(len,omax);
                 }
             }
             
             while(j<i)
             {
                 j++;
                 
                 char ch = S.charAt(j);
                 
                  if(map.get(ch)==2)
                  {  
                      int len = i-j;
                      
                      omax =Math.max(len,omax);
                      map.put(ch,1);
                      break;
                  }
                  else
                  {
                      map.remove(ch);
                  }
                 
             }
         }
         
         return omax;
        
    }
}