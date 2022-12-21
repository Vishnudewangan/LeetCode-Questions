class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int cnt=0;
        
        for(int i=0;i<nums.length;i++)
        {    
              if(nums[i]==-1) continue;
            for(int j=i+1;j<nums.length;j++)
            {
                 
                if(nums[i]==nums[j])
                {
                    nums[i]=-1;
                    nums[j]=-1;
                    cnt++;
                    break;
                }
            }
        }
        int left = nums.length - cnt*2;
        
        return new int[]{cnt,left};
        
    }
}