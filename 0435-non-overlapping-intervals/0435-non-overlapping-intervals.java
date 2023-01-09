class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
          Arrays.sort(intervals,(a,b)->{
              return Integer.compare(a[0],b[0]);
          });
        
        int n = intervals.length;
        
        
        int minCnt=0;
        
        int prevEnd = intervals[0][1];
        
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0] < prevEnd)
            {
                minCnt++;
                
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                
                
            }
            else
            {
                prevEnd= intervals[i][1];
            }
        }
        
        return minCnt;
    }
}