class Solution {
    public int maxPoints(int[][] points) {
        
        if(points.length==1) return 1;
        int ans = 0;
    
        for(int i=0;i<points.length;i++)
        {   
           HashMap<Double,Integer> map =new HashMap<>();
            
            for(int j=i+1;j<points.length;j++)
            {  
                double slope = calculateSlope(points[i],points[j]);
                map.put(slope, map.getOrDefault(slope,0)+1);
                
                ans = Math.max(ans, map.get(slope));
                
                
            }
            
        }
        
        return ans+1;
    }
    
    private double calculateSlope(int[] pnt1 , int[] pnt2)
    {
        int x1 = pnt1[0], y1 = pnt1[1];
        int x2 = pnt2[0], y2 = pnt2[1];
        
        if(x1==x2) return Double.MAX_VALUE;
        if(y1==y2) return 0.0;
        
        return (double) (y2-y1)/ (double) (x2-x1);
    }
}