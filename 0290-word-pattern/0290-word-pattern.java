class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        
        HashSet<String> hs =new HashSet<>();
        HashMap<Character,String> map =new HashMap<>();
        
        String[] strs = s.split(" ");
        
        if(pattern.length()!=strs.length) return false;
        
        
        for(int i=0;i<pattern.length();i++)
        {
            char ch = pattern.charAt(i);
            String str  = strs[i];
            
            if(map.containsKey(ch)==true)
            {
                if(map.get(ch).equals(str)==false) return false;
            }
            else
            {
                if(hs.contains(str)==true) return false;
                
                map.put(ch,str);
                hs.add(str);
            }
        }
        
        return true;
    }
}