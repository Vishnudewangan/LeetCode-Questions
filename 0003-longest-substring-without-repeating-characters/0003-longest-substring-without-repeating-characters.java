class Solution {
    public int lengthOfLongestSubstring(String s) {
      
        int l=0,r=0, maxLen =0;
        
        HashMap<Character,Integer> map =new HashMap<>();
        
        
        while(r<s.length())
        {
            char chr = s.charAt(r);
            map.put(chr,map.getOrDefault(chr,0)+1);
            
            while(map.get(chr)>1)
            {  
                char chl = s.charAt(l);
               
                if(map.get(chl)==1)
                {
                    map.remove(chl);
                }
                else
                {
                    map.put(chl, map.get(chl)-1);
                    
                }
                l++;
            }
            
            maxLen = Math.max(maxLen , r-l+1);
            r++;
        }
        return maxLen;
      
    }
}