class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        
       
         
        String s1=strs[0];
        String s2=strs[1];
        
        
        int k=0,l=0;
       int count=0;
        
        while(k<s1.length() && l<s2.length())
        {
            if(s1.charAt(k)==s2.charAt(l))
            {
                count++;
            }
            else
            {
                break;
            }
            k++;
            l++;
        }
        
        if(count==0) return "";
        
        String match = s1.substring(0,count);
        System.out.println(match);
        
        for(int i=2;i<strs.length;i++)
        {
             String str =strs[i];
            int len = str.length();
            count=0;
            
            for(int j=0;j<(match.length()<len? match.length():len);j++)
            {
                if(str.charAt(j)==match.charAt(j))
                {
                    count++;
                    System.out.println(count);
                }
                else
                {
                    break;
                }
            }
                
                if(count==0)
                {
                    return "";
                }
                match=str.substring(0,count);
        }
                
          return match;      
        
    }
}