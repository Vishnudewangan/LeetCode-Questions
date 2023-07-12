class Solution {
    public int lengthOfLongestSubstring(String s) {
        
         int i=-1, j=-1, olen = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();// char v/s frequency
        
         while(i< s.length()-1)
         {
              while(i<s.length()-1)
              {
                  i++;
                  
                  char ch = s.charAt(i);
                  
                  map.put(ch,map.getOrDefault(ch,0)+1);
                  
                  if(map.get(ch)>=2)
                  {
                      break;
                  }
                  else
                  {
                      int len = i-j;
                      
                      olen = Math.max(len , olen);
                      
                      
                  }
                  
              }
             
             while(j<i)
             {
                 j++;
                 
                 char ch = s.charAt(j);
                 
                 if(map.get(ch)==1)
                 {
                     map.remove(ch);
                    
                     
                 }
                 else
                 {
                     map.put(ch,map.get(ch)-1);
                      break;
                 }
                 
                 
             }
         }
        
        return olen;
    }
}