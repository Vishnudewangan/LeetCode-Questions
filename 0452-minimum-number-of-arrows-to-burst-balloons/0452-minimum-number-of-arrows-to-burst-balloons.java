class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        int arrows =1;
        
        int endPnt = points[0][1];
        
        for(int i=1;i<points.length;i++)
        {
            if(points[i][0] > endPnt)
            {
                arrows++;
                endPnt = points[i][1];
            }
            else
            {
                endPnt = Math.min(points[i][1],endPnt);
            }
        }
        
        return arrows;
    }
}