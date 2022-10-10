class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
       ArrayList<int[]> ans=new ArrayList<>();
        
        int idx=0;
        
        while(idx< intervals.length)
        {
            if(intervals[idx][0] < newInterval[0])
            {
                ans.add(intervals[idx]);
                idx++;
            }
            else
            {
                break;
            }
        }
        
        if(ans.size()==0 || newInterval[0] > ans.get(ans.size()-1)[1])
        {
            ans.add(newInterval);
        
        }
        else
        {
            ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], newInterval[1]);
        }
        
        while(idx < intervals.length)
        {
            if(ans.get(ans.size()-1)[1] < intervals[idx][0])
            {
                ans.add(intervals[idx]);
            }
            else
            {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[idx][1]);
            }
            idx++;
        }
        
        return ans.toArray(new int[ans.size()][]);
        
         
    }
}