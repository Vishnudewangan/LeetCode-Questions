class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int lo = 1;// min weight of package;

        int hi = Arrays.stream(weights).sum();

        int ans = hi;// default ans; // if we have ship all the packages in one day

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;// weight

            if(check(mid, days, weights) == 1){
                ans = mid ; 
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        return ans;
    }

    private int check(int mid, int days, int[] weights){

        int daysRequired = 0;// days Required to ship with mid weight

        int weightSoFar = 0;// packaged weight so far

        for(int weight : weights){
             
             if(weight > mid) return 0;

            if(weightSoFar + weight >= mid){

                if(weightSoFar + weight == mid){
                    weightSoFar = 0;
                }
                else{
                    weightSoFar = weight;
                }
                daysRequired++;
            }
            else{
                weightSoFar += weight;
            }
        }

        if(weightSoFar > 0) daysRequired++;

        if(daysRequired <= days) return 1;
        else return 0;
    }
}