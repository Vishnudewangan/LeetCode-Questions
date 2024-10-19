class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int maxOR = 0;

        for(int val: nums) maxOR = (maxOR | val);

        return findSubsetWithOR(nums,0,0,maxOR);
    }

    int findSubsetWithOR(int[] nums,int idx, int currOR, int maxOR)
    {

        if(idx == nums.length){
            if(currOR == maxOR)return 1;
            else return 0;
        }
          
        
        // take
        int takeAns= findSubsetWithOR(nums,idx+1,currOR|nums[idx],maxOR);

        // don't take
        int ntakeAns = findSubsetWithOR(nums,idx+1,currOR,maxOR);

        return takeAns + ntakeAns;
  
    }
}