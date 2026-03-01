class Solution {
    public int arrangeCoins(int n) {
        // search space will be 1 to n 

        int lo = 1;
        int hi = n-1;
        int ans = 1;// min possible ans with atleast 1 coin
        while(lo <= hi){
          int mid = lo + (hi - lo)/2;

          if(check(mid,n) == 1){
            ans = mid;
            lo = mid + 1;
          }
          else{
            hi = mid -1;
          }
        }

        return ans;
    }
    private int check(int row, int totalCoins){
        long coinsRequired = ((long)row * ((long)row + 1))/2;

       // System.out.println("row : "+ row + " coinsRequired : " + coinsRequired);

        return coinsRequired <= totalCoins ? 1 : 0 ;
    }
}