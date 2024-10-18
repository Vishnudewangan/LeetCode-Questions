class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int maxOR = 0;

        for(int val: nums) maxOR = (maxOR | val);

        int[] ans= new int[1];
        findSubsetWithOR(nums,0,0,maxOR,ans);
        
        return ans[0];
    }

    void findSubsetWithOR(int[] nums,int idx, int currOR, int maxOR, int[] ans)
    {

        if(idx == nums.length){
            if(currOR == maxOR)
            {
                ans[0]++;
            }
            return;
        }
          
        
        // take
        findSubsetWithOR(nums,idx+1,currOR|nums[idx],maxOR,ans);

        // don't take
        findSubsetWithOR(nums,idx+1,currOR,maxOR,ans);
  
    }
}