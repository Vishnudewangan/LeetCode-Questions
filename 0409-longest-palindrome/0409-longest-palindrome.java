class Solution {
    public int longestPalindrome(String s) {
      
        int[] count= new int[256];
        
        for(int ch : s.toCharArray())
        {   
            count[ch-'A']++;
        }
        
        int cnt = 0;
        
        for(int i=0;i<256;i++)
        {
            if(count[i]>=2)
            {
                cnt+=count[i]-count[i]%2;
            }
        }
        
        return cnt <s.length() ? cnt+1:cnt;
    }
    
}