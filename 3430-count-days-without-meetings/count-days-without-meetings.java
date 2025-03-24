class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            return a[0] -b[0];
        });

         int count=0;
        if(1!=meetings[0][0]) count+=(meetings[0][0] - 1);

       int lastEnd = meetings[0][1];
        for(int[] meet : meetings)
        {
            int start = meet[0];
            int end =meet[1];

            if(start <= lastEnd)
            {
                lastEnd = Math.max(lastEnd , end);
            }
            else
            {
                count+=(start - lastEnd -1);
                lastEnd=end;
            }
        }

        if(lastEnd < days)
        {
            count+=(days-lastEnd);
        }
        return count;
    }
}