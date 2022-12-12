class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val : nums)
        {
            map.put(val,map.getOrDefault(0,1)+1);
        }
        
       
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=nums.length;i++)
        {
            if(!map.containsKey(i))list.add(i);
        }
        
        return list;
    }
}