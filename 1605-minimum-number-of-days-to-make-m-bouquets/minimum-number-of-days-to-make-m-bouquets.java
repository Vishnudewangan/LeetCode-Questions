class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * (long)k > (long)bloomDay.length) return -1;

        int lo = 1;// least possible day to bloom a flower
        int hi = Arrays.stream(bloomDay).max().getAsInt();

        int ans = -1; // if not possible

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(check(mid,m,k,bloomDay) == 1){
                ans = mid;
                hi = mid -1;
            }
            else{
                lo = mid + 1;
            }
        }

        return ans;
    }
    
    private int check(int mid,int m, int k, int[] bloomDay){
      
      int adjacentFlowersTaken = 0;
      int bouquetsPossible = 0;

      for(int day = 0 ; day < bloomDay.length ; day++){

        if(bloomDay[day] <= mid){
            adjacentFlowersTaken++;
        }
        else{
            bouquetsPossible +=(adjacentFlowersTaken / k);
            adjacentFlowersTaken = 0;
        }

      }
      bouquetsPossible += (adjacentFlowersTaken / k);

      return bouquetsPossible >= m ? 1 : 0;
        
    }
}