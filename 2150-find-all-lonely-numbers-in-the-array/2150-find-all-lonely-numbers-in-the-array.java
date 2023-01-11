class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val : nums)
        {
            map.put(val , map.getOrDefault(val,0)+1);
        }
         
        List<Integer> list = new ArrayList<>();
        for(int val : nums)
        {
            if(map.get(val)<=1 && map.containsKey(val-1)==false && map.containsKey(val+1)==false)list.add(val);
        }
        
      return list;   
        
    }
}