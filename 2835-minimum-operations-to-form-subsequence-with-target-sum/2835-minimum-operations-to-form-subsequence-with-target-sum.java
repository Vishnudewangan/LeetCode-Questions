class Solution {
    public int minOperations(List<Integer> nums, int target) {
         long sum = 0;
        for(int num : nums) sum+=num;
        
        if(sum < target) return -1;
        
        Collections.sort(nums);
        
        int res = 0;
        
        while(target > 0)
        {
            int last = nums.remove(nums.size()-1);// biggest element of nums List
            
            if(sum-last >= target)
            {
                
                sum  -=last;
                
            }
            else if( last <= target)
            {
                target -=last;
                sum -=last;
            }
            else
            {
                nums.add(last/2);
                nums.add(last/2);
                res++;
            }
        }
        
        return res;
        
    }
}