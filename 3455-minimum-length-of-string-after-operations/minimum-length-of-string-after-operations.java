class Solution {
    public int minimumLength(String s) {
        int[] freq  = new int[26];
        
        for(char ch : s.toCharArray())
        {
           freq[ch -'a']++;
        }
        
        int ans = 0;
        
        for(int c : freq)
        {
          if(c>0 && c%2==0)ans+=2;
          else if(c >0 )
          {
              ans+=1;
          }
        }
        return ans;
    }
}