class Solution {
    public int subsetXORSum(int[] nums) {
       
        return helper(nums,0,0);
    }
    private int helper(int[] nums,int idx,int xsf){
        if(idx>=nums.length)
        {
          return xsf;
        }


        //sum of xor's including idx'th element
        int inc = helper(nums,idx+1,xsf^nums[idx]);
        // exclude
        int exc = helper(nums,idx+1,xsf);
        
        return inc+exc;
    }
}