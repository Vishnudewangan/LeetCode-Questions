class Solution {
    public int minFlipsMonoIncr(String s) {
      
        
        int zeroToOne =0,  oneCount =0;
        
        int i=0;
        while(i<s.length() && s.charAt(i)=='0')
        {
            i++;
        }
        
        for(;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                zeroToOne ++; // 0 -> 1
            }
            else
            {
                oneCount++;
            }
            
            if(zeroToOne > oneCount )
            {
                zeroToOne = oneCount;
            }
        }
        
        return zeroToOne;
    }
}