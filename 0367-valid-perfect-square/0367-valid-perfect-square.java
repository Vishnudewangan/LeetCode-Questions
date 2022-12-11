class Solution {
    public boolean isPerfectSquare(int num) {
     
        int lo=1 , hi = num;
        
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            
            int res = num/mid , remain = num%mid;
            
            if(mid == res && remain ==0)
            {
                return true;
            }
            else if(res > mid)
            {
                lo=mid+1;
            }
            else 
            {
                hi =mid-1;
            }
        }
        
        return false;
    }
}