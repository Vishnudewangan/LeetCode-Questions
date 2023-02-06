class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int i=0,j=n;
        
        int[] ans=new int[2*n];
        
        boolean odd=true; // odd ->true-> from first part else from second part
        
        for(int k=0;k<2*n;k++)
        {
            if(odd==true)
            {
                ans[k]=nums[i++];
                
            }
            else
            {
                ans[k] = nums[j++];
            }
            odd=!odd;
        }
        
        return ans;
    }
}