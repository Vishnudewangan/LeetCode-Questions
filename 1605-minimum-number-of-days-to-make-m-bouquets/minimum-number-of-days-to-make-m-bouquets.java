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
    
    private int check(int day,int bouquetsNeed, int adjacentFlowersNeed, int[] bloomDay){


       int adjacentFlowersTaken = bloomDay[0] <= day ? 1 : 0;
       int bouquetsPossible = 0;// bouquesPossible on day'th day

       for(int d=1 ; d < bloomDay.length ; d++){
           if(adjacentFlowersTaken == adjacentFlowersNeed){
               bouquetsPossible++;
               adjacentFlowersTaken = bloomDay[d] <= day ? 1 : 0;
               continue;
           }

           if(bloomDay[d] <= day && (adjacentFlowersTaken==0 || bloomDay[d-1] <= day)){
                 adjacentFlowersTaken++;
           }
           else{
            adjacentFlowersTaken = 0;
           }
       }

        if(adjacentFlowersTaken == adjacentFlowersNeed){
            bouquetsPossible++;
            adjacentFlowersTaken = 0;
        }

        if(bouquetsPossible >= bouquetsNeed) return 1;
        else return 0;
        
    }
}