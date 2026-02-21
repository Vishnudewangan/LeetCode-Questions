class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n  = piles.length;
        int lo = 1;
        int hi = Arrays.stream(piles)
                    .max()
                    .getAsInt();

        int ans = -1;// default ans , what if there is piles > hours

        while(lo <= hi)
        {   int mid = lo + (hi - lo)/2;//speed of eating


            if(check(mid,piles,h)==1){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        return ans;
    }
    private int check(int mid, int[] piles, int hours){
        long hoursRequired = 0;

        for(int val : piles){
            hoursRequired += val % mid == 0 ? val/ mid : val/mid + 1;
        }

        if(hoursRequired <= hours) return 1;
        else return 0;
    }
}