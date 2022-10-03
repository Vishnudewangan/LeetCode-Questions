class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int seconds=0;
        int zeroes=0;
        
        for(int i=0;i<s.length();i++)
       {
            zeroes+= s.charAt(i)=='0' ? 1 :0;
            
            if(s.charAt(i)=='1' && zeroes>0)
            {
                seconds =Math.max(zeroes, seconds+1);
            }
       }
        
        return seconds;
        
    }
}