class Solution {
    public long minimumTime(int[] time, int totalTrips) {
      
        long low=1;
        
        long minTime= time[0];
        for(int val : time)
        {
            minTime = Math.min(val,minTime);
        }
        
        long high= minTime*totalTrips;
        
        while(low<high)
        {
            long mid = low+(high-low)/2;
            
            long total = findTotalTrips(time,mid);
            
            if(total<totalTrips)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        
        return low;
        
        
        
    }
    
    long findTotalTrips(int[] time,long givenTime)
    {
        long trips = 0;
        
        for(int val : time)
        {
            trips+=((long)givenTime)/val;
        }
        
        return trips;
    }
}
