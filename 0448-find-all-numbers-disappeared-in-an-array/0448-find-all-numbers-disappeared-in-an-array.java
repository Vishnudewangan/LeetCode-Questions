class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Time - O(n) , space- O(n)
//         HashMap<Integer,Integer> map = new HashMap<>();
        
//         for(int val : nums)
//         {
//             map.put(val,map.getOrDefault(0,1)+1);
//         }
        
       
        
//         List<Integer> list = new ArrayList<>();
        
//         for(int i=1;i<=nums.length;i++)
//         {
//             if(!map.containsKey(i))list.add(i);
//         }
        
//         return list;
        
        // Time - O(n) , Space-O(1)
        
        for(int i=0;i<nums.length;i++)
        {
            int orgVal = Math.abs(nums[i]);
            int idx = orgVal - 1;
            
            if(nums[idx]>0)
            {
                nums[idx]*=-1;
            }
        }
        
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                list.add(i+1);
            }
        }
        
        return list;
    }
}