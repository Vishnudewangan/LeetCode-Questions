class Solution {
    public int maximumDifference(int[] nums) {
        
        
        /// *** O(n^2) ***
//         int ans =-1;
//         int n = nums.length;
        
//         for(int i=0;i<n;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {    
//                 if(nums[i] < nums[j])
//                 ans = Math.max(ans, nums[j] - nums[i]);
//             }
//         }
        
//         return ans;
        
        // ***** O(n) *** Best Time to buy ans sell stock if no profit happens then had to return 0 now we have to return -1;
        
        int n= nums.length;
        int res = -1;
        
        int min= nums[0];
        
        for(int i=1;i<n;i++)
        {
            res = Math.max(res, nums[i] - min);
            
            min = Math.min(min,nums[i]);
        }
        
        return res==0? -1 : res;
    }
}