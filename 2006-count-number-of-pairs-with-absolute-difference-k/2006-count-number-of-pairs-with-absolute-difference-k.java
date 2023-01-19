class Solution {
    public int countKDifference(int[] nums, int k) {
        
        int count=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
           int val = nums[i];
            
            if(map.containsKey(val-k)==true)
            {
                count+=map.get(val-k);
            }
            if(map.containsKey(val+k)==true)
            {
                count+=map.get(val+k);
            }
            
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        return count;
    }
}