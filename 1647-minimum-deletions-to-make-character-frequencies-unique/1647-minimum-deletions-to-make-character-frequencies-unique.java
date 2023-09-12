class Solution {
    public int minDeletions(String s) {
        
        int[] freq=new int[26];
        
        for(char ch : s.toCharArray())
        {
            freq[ch-'a']++;
        }
        
      
        
        HashSet<Integer> hs=new HashSet<>();
        
       
        int count=0;
        
        for(int i=0;i<26;i++)
        {
           int val=freq[i];
            
            while(val!=0 && hs.contains(val)==true)
            {
              count++;
                val--;
            }
            
            hs.add(val);
        }
        
        return count;
    }
}