class Solution {
    public int missingNumber(int[] nums) {
        
        int xor= 0;
        for(int val : nums)
        {
            xor^=val;
        }
        int xor1=0;
        if(nums.length%4==0) xor1=nums.length;
        if(nums.length%4==1) xor1=1;
        if(nums.length%4==2) xor1= nums.length+1;
        if(nums.length%3==3)xor1=0;
        
        
        
        return xor^xor1;
        
    }
}