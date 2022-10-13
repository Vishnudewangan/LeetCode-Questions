//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        
        StringBuilder sb =new StringBuilder();
        // code here
        
        String[] str={" ","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
        
        for(int i=0;i<S.length();i++)
        {
            char ch = S.charAt(i);
            if(ch==' ') {
                  sb.append(0);
                  continue;
            }
            
          l1:  for(int j=1;j<=8;j++)
            {
                String s = str[j];
                
                for(int k=0;k<s.length();k++)
                {
                    if(s.charAt(k)==ch)
                    {
                        for(int x=1;x<=k+1;x++)
                        {
                            sb.append(j+1);
                        }
                        break l1 ;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}