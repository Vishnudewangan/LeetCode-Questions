class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i=-1;
        int j=-1;
        
        HashMap<Character,Integer> map =new HashMap<>();
        
        int maxLen = 0;
        
        while(i<s.length()-1)
        {
            while(i<s.length()-1)
            {
                i++;
                
                char ch = s.charAt(i);
                
               map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.get(ch)==1)
                {
                   int len =i-j;
                    
                    maxLen = Math.max(len,maxLen);
                }
                else if(map.get(ch)==2)
                {
                    break;
                }
            }
            
            while(j<i)
            {
                j++;
                char ch = s.charAt(j);
                
                int nf = map.get(ch);
                
                if(nf==1)
                {
                    map.remove(ch);
                }
                else if(nf==2)
                {
                    map.put(ch,1);
                    break;
                }
            }
        }
        
        return maxLen;
    }
}