class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {   int val = nums[i];
            if(map.containsKey(target-val)==true)
            {
                return new int[]{i,map.get(target-val)};
            }
            map.put(val,i);
        }
        
        return new int[]{};
    }
}