class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int cnt=0;
        
        int n= nums.length;
        
        for(int i=1;i<n;i++)
        {
            if(nums[i-1] > nums[i])
            {
        
               cnt++;
                
                if(i-2<0 || nums[i-2]<=nums[i])  nums[i-1]= nums[i];
                else nums[i] = nums[i-1];
            }
        }
        
        return cnt<=1;
    }
}