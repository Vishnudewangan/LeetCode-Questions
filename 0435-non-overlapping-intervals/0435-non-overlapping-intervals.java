class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        ArrayList<int[]> ans =new ArrayList<>();
         
        
        Arrays.sort(intervals, (a,b)->{
            return a[0] - b[0];
        });
        
        ans.add(intervals[0]);
        
   
        
        int count=0;
        
        for(int i=1;i<intervals.length;i++)
        {
            int cstart=intervals[i][0];
            int cend = intervals[i][1];
            
            int pstart= ans.get(ans.size()-1)[0];
            int pend =ans.get(ans.size()-1)[1];
            
            if(pend>cstart)
            {
                ans.get(ans.size()-1)[1]=Math.min(cend,pend);
                count++;
                // System.out.println(count);
            }
            else
            {
                ans.add(intervals[i]);
            }
        }
        
        // System.out.println(ans.size());
        
        return intervals.length - ans.size();
        
        // return count;
    }
}