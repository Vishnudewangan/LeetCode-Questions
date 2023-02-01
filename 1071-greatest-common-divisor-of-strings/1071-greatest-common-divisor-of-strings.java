class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        String ans="";
        
        for(int i=0;i<str2.length();i++)
        {
            String pat = str2.substring(0,i+1);
            
            if(isPossible(pat,str1)==true && isPossible(pat,str2)==true)
            {
                ans = pat;
            }
        }
        
        return ans;
    }
    
    boolean isPossible(String pat , String str)
    {
        StringBuilder sb =new StringBuilder(pat);
        
        while(sb.length() <= str.length())
        {
            if(sb.toString().equals(str)==true)
            {
                return true;
            }
            
            sb.append(pat);
        }
        
        return false;
    }
}