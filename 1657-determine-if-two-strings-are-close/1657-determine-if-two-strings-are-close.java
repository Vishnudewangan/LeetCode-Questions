class Solution {
    public boolean closeStrings(String word1, String word2) {
        
         int[] freq1 =new int[26];
         int[] freq2 = new int[26];
        
         
        for(int i=0;i<word1.length();i++)
        {
            char ch = word1.charAt(i);
            
            freq1[ch-'a']++;
        }
        
        for(int j=0;j<word2.length();j++)
        {  
            char ch = word2.charAt(j);
            freq2[ch-'a']++;
        }
        
       for(int i=0;i<26;i++)
       {
           if((freq1[i]==0 && freq2[i]!=0)|| (freq1[i]!=0 && freq2[i]==0))
           {
               return false;
           }
                                             
       }
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        
        for(int i=0;i<26;i++)
        {
            if(freq1[i]!=freq2[i])
            {
                return false;
            }
        }
        
        return true;
            
    }
}