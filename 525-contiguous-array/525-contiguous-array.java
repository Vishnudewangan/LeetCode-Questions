class Solution {
    public int findMaxLength(int[] nums) {
      
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nums[i]=-1;
            }
        }
        
        int ps=0;
        
        int k=0;
        
        HashMap<Integer,Integer> map =new HashMap<>();
        
        map.put(0,-1);
        int olen = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            ps+=nums[i];
            
            if(map.containsKey(ps-k)==true)
            {
                int len = i-map.get(ps-k);
                
                olen = Math.max(len,olen);
            }else
            map.put(ps,i);
        }
        
        return olen==Integer.MIN_VALUE ? 0 : olen;
    }
}