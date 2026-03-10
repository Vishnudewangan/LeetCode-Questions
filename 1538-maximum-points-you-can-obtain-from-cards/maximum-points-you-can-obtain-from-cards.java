class Solution {
    public int maxScore(int[] cardPoints, int k) {
      int n = cardPoints.length;

      int[] pSum = new int[n];
      pSum[0] = cardPoints[0];

      int maxSum = 0;
      for(int i=1;i<n;i++) pSum[i] =pSum[i-1] + cardPoints[i];

      if(n==k) return pSum[n-1];

      for(int i=0;i<=k;i++)
      {
        int sum = pSum[n-1] - pSum[n -1 - k + i];//from back k - i elements
        sum += (i== 0 ? 0 : pSum[i-1]);// from front i elements

        maxSum = Math.max(maxSum , sum);
      }

      return maxSum;
    }
}