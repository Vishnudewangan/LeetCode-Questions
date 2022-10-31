class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int i=-1;
        int j=-1;
        int maxLen = 0;
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        while(i<n-1)
        {
            while(i<n-1)
            {
                i++;
                
                char val = s.charAt(i);
                
                map.put(val,map.getOrDefault(val,0)+1);
                
                if(map.get(val)==2)
                {
                    break;
                }
                
                int len = i-j;
                
                maxLen = Math.max(len, maxLen);
                
            }
            while(j<i)
            {
                j++;
                
                char val =s.charAt(j);
                
                if(map.get(val)==1)
                {
                    map.remove(val);
                }
                else if(map.get(val)==2)
                {
                    map.put(val,1);
                    break;
                }
            }
        }
        
        return maxLen;
    }
}