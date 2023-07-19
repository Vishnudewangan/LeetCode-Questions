class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals,(a,b)->{
             return a[0]-b[0];
        });
        
        int min = 0;
        
        int end = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]< end)
            {
                min++;
                end = Math.min(intervals[i][1],end);
               
            }
            else
            {
                end = intervals[i][1];
            }
            
        }
        
        return min++;
        
        
    }
}