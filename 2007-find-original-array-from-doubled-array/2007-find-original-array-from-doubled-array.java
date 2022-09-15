class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if(changed.length%2==1) return new int[0];
        
        
             Arrays.sort(changed);
         HashMap<Integer,Integer> map =new HashMap<>();
        
          for(int val : changed)
          {
              map.put(val,map.getOrDefault(val, 0)+1);
          }
         
        
        
         
        int k=0;
         int[] res =new int[changed.length/2];
        
        Arrays.sort(changed);
        
        for(int i=0;i< changed.length ;i++)
        {
            int key = changed[i];
            
            if(map.get(key)==0) continue;
            
            map.put(key,map.get(key)-1);
            
            
            if(map.containsKey(key*2)==false)
            {
                return new int[0];
            }
            else if(map.get(key*2)==0)
            {
                return new int[0];
            }
            
            res[k++]=key;
            
            map.put(key*2 , map.get(key*2)-1);
            
        }
        
      
        
        return res;
    }
}