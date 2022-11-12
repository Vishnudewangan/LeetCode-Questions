class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list =new ArrayList<>();
        
        if(s.length() < p.length()) return list;
        
        HashMap<Character,Integer> pm=new HashMap<>();// pattern  map
        
        HashMap<Character, Integer> wm = new HashMap<>();// window map
        
        for(int i=0;i<p.length();i++)
        {  
            char ch = p.charAt(i);
            pm.put(ch, pm.getOrDefault(ch, 0)+1);
        }
        
        // first window 
        
        int i=0;
        int j=0;
        
        for(; i<p.length();i++)
        {
           char ch = s.charAt(i);
            
            wm.put(ch, wm.getOrDefault(ch, 0)+1);
        }
        
       
        
         while(i< s.length())
         {
             if(mapsAreEqual(pm,wm)== true)
             {
                 list.add(j);
             }
             
              // for getting other ans we will acqiure ith  char and release jth char
             
             char ch1 = s.charAt(i);
             
             wm.put(ch1, wm.getOrDefault(ch1, 0)+1);
             
             char ch2 =s.charAt(j);
             
            if(wm.get(ch2)==1)
            {
                wm.remove(ch2);
            }
             else
             {
                int nf = wm.get(ch2)-1;
                 
                 wm.put(ch2, nf);
             }
             i++;
             j++;
             
             
         }
        if(mapsAreEqual(pm,wm)== true)
             {
                 list.add(j);
             }
        
        return list;
    }
    
    public boolean mapsAreEqual(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2)
    {
        if(map1.size()!=map2.size()) return false;
        
        for(char key : map1.keySet())
        {
            if(map2.containsKey(key)==false)
            {
                return false;
            }
            int val1= map1.get(key);
            int val2 =map2.get(key);
            
            if(val1!=val2)
            {
                return false;
            }
        }
        
        return true;
        
    }
}