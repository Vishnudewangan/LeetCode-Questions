class Solution {
    public int deleteAndEarn(int[] nums) {
        
        
        int max = nums[0];
        for(int val : nums) max = Math.max(max, val);
        int[] freq =new int[max+1];
        
        for(int i=0;i<nums.length;i++)
        {
           freq[nums[i]]++; 
        }
        
        HashMap<Integer,Integer> memo =new HashMap<>();
        

        return helper(freq,1,memo);
    }
    
    
    int helper(int[] freq , int currentIndex,HashMap<Integer,Integer> memo)
    {
        if(currentIndex >= freq.length) return 0;
        
        int key = currentIndex;
        
        if(memo.containsKey(key)) return memo.get(key);
        
        int delete = currentIndex*freq[currentIndex] + helper(freq,currentIndex+2,memo);
        int nonDelete = helper(freq, currentIndex+1,memo);
        
        
         int max = Math.max(delete , nonDelete);
         memo.put(key, max);
        
        return max;
    }
}