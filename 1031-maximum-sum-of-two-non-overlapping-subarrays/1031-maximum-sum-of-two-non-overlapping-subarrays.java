class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int[] sum = new int[nums.length+1];
          int i=1;
         for(int val : nums)
         {
             sum[i]=sum[i-1]+val;
             i++;
             
         }
        
        
        return Math.max(maxSum(sum,firstLen, secondLen),maxSum(sum,secondLen, firstLen));
        
    }
    
    int maxSum(int[] sum , int L , int M)
    {
        
        int maxSumL = sum[L];
        int maxSumLM = sum[L+M];
        
        for(int i=L+M+1;i<sum.length;i++)
        {
            int currSumL = sum[i-M] - sum[i-L-M];
            int currSumM  = sum[i] - sum[i-M];
            
            
            maxSumL = Math.max(currSumL, maxSumL);
            
            maxSumLM = Math.max(maxSumLM , currSumM + maxSumL);
            
        }
        
        return maxSumLM;
    }
}