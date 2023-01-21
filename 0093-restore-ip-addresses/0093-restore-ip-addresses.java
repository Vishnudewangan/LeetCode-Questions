class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<>();
        
        helper(s,0,0,"",res);
        return res;
    }
    
    void helper(String str, int i, int par , String ans, List<String> res)
    {
          if(i==str.length() || par== 4)
          {
              if(i==str.length() && par==4)
              {
                res.add(ans.substring(0,ans.length()-1));  
              } 
              
              return;
          }
        
          helper(str,i+1,par+1,ans+str.charAt(i)+".", res);
        
         if(i+2<=str.length() && isValid(str.substring(i,i+2))==true)
         {
              helper(str,i+2,par+1,ans+str.substring(i,i+2)+".",res);
         }
        
        if(i+3<=str.length() && isValid(str.substring(i,i+3))==true)
        {
              helper(str,i+3,par+1,ans+str.substring(i,i+3)+".",res);
        }
             
    }
    
    boolean isValid(String str)
    {
        if(str.charAt(0)=='0') return false;
        
        int val = Integer.parseInt(str);
        
        return val<=255;
    }
}