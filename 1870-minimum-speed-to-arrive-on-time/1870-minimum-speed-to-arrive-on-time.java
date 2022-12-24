class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
       
        int low = 1, hi = (int)1e7;
        
        while(low<=hi)
        {
            int mid = low + (hi- low)/2;
            
            if(isPossible(dist,mid,hour))
            {
               
                 hi = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return low > (int)1e7 ? -1 : low;
    }
    
    boolean isPossible(int[] dist , int speed,double hour)
    {
          double totalHoursReq = 0;
        
        for(int i=0;i<dist.length-1;i++)
        {
            totalHoursReq += Math.ceil((dist[i]*1.0)/speed);
        }
        
        totalHoursReq+=(dist[dist.length-1]*1.0)/speed;
        return totalHoursReq<=hour;
    }
}