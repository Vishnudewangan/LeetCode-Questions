class Solution {
    public int minSubarray(int[] nums, int p) {
        int remArr=0, ps=0, olen=nums.length;
        
        for(int val : nums)
        {
            remArr=(remArr+val)%p;
        }
        
        if(remArr== 0) return 0;
        HashMap<Integer, Integer> map=new HashMap<>();// ps%p vs last index
        
        map.put(0,-1);
        
        for(int i=0;i<nums.length;i++)
        {
            ps=ps%p + nums[i];
            
           int key=(ps-remArr)%p;
            if(key<0) key+=p;
           
            
            if(map.containsKey(key)==true)
            {
                int len=i-map.get(key);
                olen=Math.min(len, olen);
            }
            
            
           map.put(ps%p,i);
        }
        
        return olen==nums.length? -1 : olen;
    }
}