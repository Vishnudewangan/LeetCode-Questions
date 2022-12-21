class Solution {
    public int totalHammingDistance(int[] nums) {
      
        int n= nums.length;
        int ans=0;
        
        for(int i=0;i<32;i++)
        {
            int zero=0,one=0;
            
            int mask = (1<<i);
            
            for(int val : nums)
            {
                if((mask&val)>0)
                {
                    one++;
                }
                else
                {
                    zero++;
                }
            }
            
            if(zero==n || one==n)
            {
                continue;
            }
            else
            {
               ans+=(zero*one);
            }
        }
        return ans;
      
    }
}