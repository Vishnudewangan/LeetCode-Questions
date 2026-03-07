class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] odd = new int[100001];
        int[] even = new int[100001];

        int oddMax = 0;
        int oddMaxFreq = 0;
        int oddSecondMax = 0;
        int oddSecondMaxFreq = 0;

        for(int i = 1;i < nums.length ; i+=2)
        {
            odd[nums[i]]++;
        }

        for(int i=0;i<odd.length;i++)
        {
            if(oddMaxFreq <= odd[i]){
              oddSecondMax = oddMax;
              oddSecondMaxFreq = oddMaxFreq;
              
              oddMax = i;
              oddMaxFreq = odd[i];

            }
            else if(oddSecondMaxFreq < odd[i]){
                oddSecondMax = i;
                oddSecondMaxFreq = odd[i];
            }
        }


        int evenMax = 0;
        int evenMaxFreq = 0;
        int evenSecondMax = 0;
        int evenSecondMaxFreq = 0;

        for(int i = 0;i < nums.length ; i+=2)
        {
            even[nums[i]]++;
        }

        for(int i=0;i<even.length;i++)
        {
            if(evenMaxFreq <= even[i]){
              evenSecondMax = evenMax;
              evenSecondMaxFreq = evenMaxFreq;
              
              evenMax = i;
              evenMaxFreq = even[i];

            }
            else if(evenSecondMaxFreq < even[i]){
                evenSecondMax = i;
                evenSecondMaxFreq = even[i];
            }
        }

        if(oddMax !=evenMax){
            return n - oddMaxFreq - evenMaxFreq;
        }

        return Math.min(n - oddMaxFreq - evenSecondMaxFreq, n - evenMaxFreq - oddSecondMaxFreq);
    }
}