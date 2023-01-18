class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int[] nonCircularMaxSubArraySumandTotalSum = kedanes(nums);
        
        int nonCircularMaxSubArraySum= nonCircularMaxSubArraySumandTotalSum[0];
        int totalSum = nonCircularMaxSubArraySumandTotalSum[1];
        
        // System.out.println(nonCircularMaxSubArraySum+"  "+totalSum);
        int minSubArraySum = kedanesMin(nums);
        
        // System.out.println(minSubArraySum);
        
        int circularMaxSubArraySum = totalSum - minSubArraySum;
         if(circularMaxSubArraySum==0) return nonCircularMaxSubArraySum;
        return Math.max(nonCircularMaxSubArraySum, circularMaxSubArraySum);
    }
    
    int[] kedanes(int[] arr)
    {
        int sum=arr[0];
        
        int maxSum = arr[0];
        int sumSoFar = arr[0];
        
        for(int i=1;i<arr.length;i++)
        {   
            int val = arr[i];
            sum+=val;
            
            if(sumSoFar > 0)
            {
                 sumSoFar += val;
            }
            else
            {
                sumSoFar = val;
            }
            
            maxSum = Math.max(sumSoFar , maxSum);
        }
        
        return new int[]{maxSum,sum};
    }
    
    int kedanesMin(int[] arr)
    {
        int minSum = arr[0];
        int sumSoFar = arr[0];
        
        for(int i=1;i<arr.length;i++)
        {   
            int val = arr[i];
           
            if(sumSoFar < 0)
            {
                sumSoFar +=val;
            }
            else
            {
                sumSoFar = val;
            }
            
            minSum =Math.min(sumSoFar , minSum);
        }
        return minSum;
    }
}