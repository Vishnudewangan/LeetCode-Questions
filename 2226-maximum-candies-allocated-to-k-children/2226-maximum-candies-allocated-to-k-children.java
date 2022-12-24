class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        long sum=0;
        for(int val : candies) sum+=val;
       
        long low= 0 , hi = sum;
        
        long ans=0;
        
        while(low<=hi)
        {
            long mid = (low+hi)/2;
            
            
            if(isPossible(candies,mid,k))
            {   ans= mid;
                low= mid+1;
            }    
            else
            {
                hi = mid-1;
            }
        }
        return (int)ans;
    }
    
    boolean isPossible(int[] candies , long cand, long pile )
    {    
        if(cand==0) return true;
         long possiblePile =0;
        
        for(int val : candies)
        {
             possiblePile+= val/cand;
            
            
            if(possiblePile>=pile)
            {
                return true;
            }
        }
        return false;
        
    }
}