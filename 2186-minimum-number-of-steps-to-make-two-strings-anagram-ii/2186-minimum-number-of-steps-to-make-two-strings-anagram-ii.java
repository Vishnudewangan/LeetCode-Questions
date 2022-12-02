class Solution {
    public int minSteps(String s, String t) {
        
        int[] freq= new int[261];
        
        for(char ch : s.toCharArray())
        {
            freq[ch-'a']++;
        }
        
        for(char ch : t.toCharArray())
        {
            freq[ch-'a']--;
        }
        
        int ans = 0;
        
        for(int val : freq)
        {
            ans+=Math.abs(val);
        }
        
        return ans;
    }
}