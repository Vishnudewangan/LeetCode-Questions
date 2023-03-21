class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long ans=0, numSubArray=0;
        
        for(int val : nums)
        {
            if(val==0)numSubArray++;
            else numSubArray=0;
            
            ans+=numSubArray;
        }
        
        return ans;
    }
}