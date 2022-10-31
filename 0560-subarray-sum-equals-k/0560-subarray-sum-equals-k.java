class Solution {
    public int subarraySum(int[] nums, int k) {
      
        HashMap<Integer,Integer> map =new HashMap<>();
        
        map.put(0,1);
        
        int count =0;
        
        int ps =0;
        
        for(int i=0;i<nums.length;i++)
        {
            ps+=nums[i];
            
            if(map.containsKey(ps-k)==true)
            {
                count+= map.get(ps-k);
            }
            
            map.put(ps,map.getOrDefault(ps,0)+1);
        }
       
        
        
        return count;
        
       
        
        
    }
}