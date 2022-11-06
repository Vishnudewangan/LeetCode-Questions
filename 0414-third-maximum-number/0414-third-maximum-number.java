class Solution {
    public int thirdMax(int[] nums) {
        
        TreeSet<Integer> set =new TreeSet<>();
        
        for(int val : nums)
        {
            if(set.contains(val)==true)
            {
                continue;
            }
            
            
            set.add(val);
            if(set.size()>3)
            {
                set.pollFirst();
               
            }
        }
        
        return set.size()== 3? set.first():set.last();
    }
}