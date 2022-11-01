class Solution {
    public boolean isIsomorphic(String s, String t) {
         
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for(int i=0;i<s.length();i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            if(map.containsKey(sc)==false)
            {
                if(hs.contains(tc)==true)
                {
                    return false;
                }
                
                map.put(sc,tc);
                hs.add(tc);
            }
            else
            {
                if(map.get(sc)!= tc)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}