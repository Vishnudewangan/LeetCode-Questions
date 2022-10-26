class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
       HashMap<Integer,Integer> map=new HashMap<>();
        
        map.put(0,-1);
        
        int ps=0;
        
        int olen=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            ps+=nums[i];
            
            int rem =ps%k;
            
            if(map.containsKey(rem)==true)
            {
                int len = i-map.get(rem);
                
                olen = Math.max(len,olen);
                
                if(olen>=2) return true;
            }
            else{
                map.put(rem,i);
            }
            
        }
        
        return false;
        
    }
}