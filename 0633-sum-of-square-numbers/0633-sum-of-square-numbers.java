class Solution {
    public boolean judgeSquareSum(int c) {
        
        for(long a=0;a*a<=c;a++)
        {
            int b = c - (int)(a*a);
            
            if(binarySearch(0,b,b)) return true;
            
            
        }
        return false;
    }
    
    public boolean binarySearch(long lo , long hi ,int n)
    {
        if(lo> hi) return false;
        
        long mid = lo + (hi- lo)/2;
        
        if(mid*mid==n) return true;
        else if(mid*mid >n) return binarySearch(lo,mid-1,n);
        else return binarySearch(mid+1,hi,n);
        
    }
}