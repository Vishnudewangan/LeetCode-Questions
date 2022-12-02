class Solution {
    public int minSteps(String s, String t) {
        
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray())
        {
            freq[ch-'a']++;
        }
        
        for(char ch : t.toCharArray())
        {
            freq[ch-'a']--;
        }
        
        int ans=0;
        
        for(int val : freq)
        {
            ans+= val>0 ? val : 0;
        }
        
        return ans;
    }
}