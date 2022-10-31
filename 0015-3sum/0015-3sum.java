class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        int target = 0;
        
        for(int i=0;i<nums.length-2;i++)
        {
            if(i>0 && nums[i]== nums[i-1])
            {
                continue;
            }
            
            List<List<Integer>> list = twoSum(nums,i+1,target-nums[i]);
            
            for(List<Integer> temp : list)
            {
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        
        return ans;
    
    }
    List<List<Integer>> twoSum(int[] nums,int si, int target)
    {
        int i=si, j=nums.length-1;
        
        List<List<Integer>> ans =new ArrayList<>();
        
        while(i<j)
        {
            if(i!=si && nums[i]== nums[i-1])
            {
                i++;
                continue;
            }
            
           
            if(nums[i]+nums[j]==target)
            {    List<Integer> temp=new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
                i++;
                j--;
            }
            else if(nums[i]+nums[j]<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return ans;
        
        
    }
}