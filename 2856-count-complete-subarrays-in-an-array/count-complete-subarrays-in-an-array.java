class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
      HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int val: nums) map.put(val,map.getOrDefault(val,0)+1);
        
        int rqrd = map.size();
        
        map =new HashMap<>();
        int ans=0;
        
        for(int i=0;i<nums.length;i++)
        {   map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.size()==rqrd)ans++;
            for(int j=i+1;j<nums.length;j++)
            {
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                if(map.size()==rqrd)ans++;
            }
         map =new HashMap<>();
        }
        return ans;
    }
}