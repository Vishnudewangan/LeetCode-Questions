class Solution {
    public int maximumXOR(int[] nums) {
       
       int ans = 0;

       for(int i = 31; i >= 0; i--)
        {   int mask = (1 << i);
            int cnt = 0;
            for(int j = 0 ; j < nums.length; j++){
                
                if((nums[j] & mask) >= 1) cnt++;
            }
            if(cnt > 0 ) ans ^= mask;
       }

       return ans;
    }
}