class Solution {
    public int singleNumber(int[] nums) {
        
        int ans = 0;
        
        
        for(int i=0;i<32;i++)
        {
             int countONBITS=0;
             int mask = 1<<i;
            for(int val : nums)
            {
               if((mask & val) !=0)  countONBITS++;
            }
            
            if(countONBITS % 3 !=0) ans+=mask;
           
        }
        
        return ans;
        
    
    }
}