class Solution {
    public String longestPalindrome(String s) {
        
        int[] si =new int[1];
        int[] len =new int[1];
        len[0] = 1;
        
        for(int i=0;i<s.length();i++)
        {
            solve(s,i,i,si,len);
            if(i<s.length()-1)
            {
                solve(s,i,i+1,si,len);
            }
        }
        
        // System.out.println(si[0]+" " + len[0]);
        return s.substring(si[0],si[0]+len[0]);
    }
    
    void solve(String str, int i, int j,int[] si, int[] len)
    {
        while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j))
        {
            i--;
            j++;
        }
        
        i++;
        j--;
        
        int tempLen = j-i+1;
        
        if(len[0] < tempLen)
        {
            si[0]=i;
            len[0] = tempLen;
        }
    }
}