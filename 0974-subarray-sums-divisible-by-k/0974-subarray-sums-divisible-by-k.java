class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map =new HashMap<>();// ps%k vs count
        int ps=0;
        int oans=0;
        
        
        map.put(0,1);
        
        for(int i=0;i<nums.length;i++)
        {
            ps+=nums[i];
            
            int rem =ps%k<0 ? ps%k+k : ps%k;
            
            if(map.containsKey(rem)==true)
            {
                oans+=map.get(rem);
                
                
            }
            
            map.put(rem, map.getOrDefault(rem,0)+1);
            
            
        }
        
        return oans;
        
    }
}